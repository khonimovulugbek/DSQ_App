package uz.atm.model.dsq.purchaseInfoResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.model.base.Auditable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/31/22 12:10 PM
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseInfoResponse extends Auditable {

    private Boolean success;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Embedded
    private PurchaseInfoDto data;

}
