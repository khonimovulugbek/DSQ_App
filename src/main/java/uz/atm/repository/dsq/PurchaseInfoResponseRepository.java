package uz.atm.repository.dsq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.atm.model.dsq.purchaseInfoResponse.PurchaseInfoResponse;

import java.util.List;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/31/22 12:30 PM
 **/
public interface PurchaseInfoResponseRepository extends JpaRepository<PurchaseInfoResponse, Long> {
    @Query("select p from PurchaseInfoResponse p where p.data.customerTin is null or p.data.exucutorTin is null")
    List<PurchaseInfoResponse> findAllByTin();

    @Transactional
    @Modifying
    @Query("delete from PurchaseInfoResponse p where p.data.lotNumber = ?1")
    void deleteByLot(Long lot);
}
