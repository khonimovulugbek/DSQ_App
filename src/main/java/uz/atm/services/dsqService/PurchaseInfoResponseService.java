package uz.atm.services.dsqService;

import org.springframework.stereotype.Service;
import uz.atm.model.dsq.purchaseInfoResponse.PurchaseInfoDto;
import uz.atm.model.dsq.purchaseInfoResponse.PurchaseInfoResponse;
import uz.atm.repository.dsq.PurchaseInfoResponseRepository;
import uz.atm.repository.methodsRepo.ResultatMethodRepository;

import java.util.List;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/31/22 12:30 PM
 **/
@Service
public class PurchaseInfoResponseService extends AbstractService<PurchaseInfoResponseRepository> {
    private final ResultatMethodRepository resultatMethodRepository;

    public PurchaseInfoResponseService(PurchaseInfoResponseRepository repository, ResultatMethodRepository resultatMethodRepository) {
        super(repository);
        this.resultatMethodRepository = resultatMethodRepository;
    }


    public PurchaseInfoResponse save(PurchaseInfoResponse response) {
        return repository.save(response);
    }

    public List<PurchaseInfoDto> list() {

        return repository.findAllByTin().stream().map(PurchaseInfoResponse::getData)
                .peek(dto -> {
                    var r = resultatMethodRepository
                            .findByPayload_LotId(dto.getLotNumber());
                    if (r.isPresent()) {
                        var payload = r.get().getPayload();
                        dto.setCustomerTin(Long.valueOf(payload.getInn()));
                        dto.setExucutorTin(Long.valueOf(payload.getVendorInn()));
                    }
                }).toList();
    }

    public void delete(Long lotNumber) {
        repository.deleteByLot(lotNumber);
    }
}
