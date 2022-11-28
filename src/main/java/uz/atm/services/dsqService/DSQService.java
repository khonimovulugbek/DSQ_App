package uz.atm.services.dsqService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.atm.dto.DSQDataDto;
import uz.atm.dto.DSQResponse;
import uz.atm.model.dsq.purchaseInfoResponse.PurchaseInfoDto;
import uz.atm.model.dsq.purchaseInfoResponse.PurchaseInfoResponse;
import uz.atm.properties.DSQApiProperties;
import uz.atm.services.callerService.DSQCaller;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 03/10/22
 * Time: 09:58
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DSQService {
    private final DSQCaller dsqCaller;
    private final DSQApiProperties dsqApiProperties;
    private final PurchaseInfoResponseService purchaseInfoResponseService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public DSQDataDto<PurchaseInfoResponse> sendPurchaseInfo(PurchaseInfoDto dto) {
        DSQApiProperties.Url url = dsqApiProperties.getUrl();
        String endpoint = url.getProtocol() + url.getDomain() + url.getPath().getPurchaseInfoAPI();
        DSQResponse<String> response = dsqCaller.postCall(dto, endpoint);
        if (response.isUnAuthorized) {
            dsqCaller.loginCall();
            response = dsqCaller.postCall(dto, endpoint);
        }
        try {
            if (!response.isUnAuthorized) {
                PurchaseInfoResponse newRes = objectMapper.readValue(response.body, PurchaseInfoResponse.class);
                return new DSQDataDto<>(newRes);
            } else {
                return new DSQDataDto<>(response.body);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return new DSQDataDto<>(e.getMessage());
        }
    }

    @PostConstruct
    public void send(){
        purchaseInfoResponseService.list().stream()
                .map(this::sendPurchaseInfo)
                .toList().forEach(dto -> {
                    purchaseInfoResponseService.delete(dto.getBody().getData().getLotNumber());
                    purchaseInfoResponseService.save(dto.body);
                });
    }
}
