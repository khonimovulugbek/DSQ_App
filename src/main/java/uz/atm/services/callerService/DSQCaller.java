package uz.atm.services.callerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.atm.dto.DSQResponse;
import uz.atm.dto.DsqError;
import uz.atm.dto.enums.Session;
import uz.atm.properties.DSQApiProperties;
import uz.atm.services.ApiMessages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static uz.atm.utils.AppUtils.isJWT;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 16:23
 */
@Service
@Slf4j
public class DSQCaller {

    private final DSQApiProperties dsqApiProperties;
    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public DSQCaller(DSQApiProperties dsqApiProperties, RestTemplate restTemplate) {
        this.dsqApiProperties = dsqApiProperties;
        this.restTemplate = restTemplate;
    }

    public void loginCall() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> map = new HashMap<>();
        map.put("username", dsqApiProperties.getUser());
        map.put("password", dsqApiProperties.getPassword());

        var request = new HttpEntity<>(map, headers);
        DSQApiProperties.Url url = dsqApiProperties.getUrl();
        String loginPath = url.getProtocol() + url.getDomain() + url.getPath().getLoginAPI();
        ResponseEntity<String> response = restTemplate.postForEntity(loginPath, request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            if (response.hasBody() && isJWT(Objects.requireNonNull(response.getBody()))) {
                Session.INSTANCE.setValue(response.getBody());
            } else {
                try {
                    objectMapper.readValue(response.getBody(), DsqError.class);
                    log.error("{} endpoint : [{}],error: {}", ApiMessages.ERROR_WHILE_CALLING_TAX_COMMITTEE, loginPath, response.getBody());
                } catch (JsonProcessingException e) {
                    log.error("{} endpoint : [{}]", ApiMessages.ERROR_WHILE_CALLING_TAX_COMMITTEE, loginPath);
                }
            }
        } else {
            log.error("{} endpoint : [{}], statusCode: [{}]", ApiMessages.ERROR_WHILE_CALLING_TAX_COMMITTEE, loginPath, response.getStatusCode());
        }
    }


    public DSQResponse<String> getCall(Map<String, String> params, String endpoint) {

        if (Session.INSTANCE.getValue() == null) {
            this.loginCall();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Session.INSTANCE.getValue());
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity, String.class, params);
            if (response.getStatusCode() == HttpStatus.UNAUTHORIZED || response.getStatusCode() == HttpStatus.FORBIDDEN) {
                return new DSQResponse<>(response.getBody(), true);
            } else {
                String body = response.getBody();
                return new DSQResponse<>(body);
            }
        } catch (Exception e) {
            return new DSQResponse<>(ExceptionUtils.getRootCauseMessage(e));
        }
    }

    public DSQResponse<String> postCall(Object body, String endpoint) {
        if (Session.INSTANCE.getValue() == null) {
            this.loginCall();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Session.INSTANCE.getValue());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Object> httpEntity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(endpoint, HttpMethod.POST, httpEntity, String.class);
            if (response.getStatusCode() == HttpStatus.UNAUTHORIZED || response.getStatusCode() == HttpStatus.FORBIDDEN) {
                return new DSQResponse<>(response.getBody(), true);
            } else {
                String responseBody = response.getBody();
                return new DSQResponse<>(responseBody);
            }
        } catch (Exception e) {
            return new DSQResponse<>(ExceptionUtils.getRootCauseMessage(e), true);
        }
    }
}
