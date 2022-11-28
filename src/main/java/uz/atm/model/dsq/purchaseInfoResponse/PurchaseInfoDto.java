package uz.atm.model.dsq.purchaseInfoResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/09/22
 * Time: 10:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class PurchaseInfoDto {

    @JsonProperty("account")
    private String account;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("buyer_code")
    private String buyerCode;

    @JsonProperty("contract_date")
    private String contractDate;

    @JsonProperty("contract_id")
    private Long contractId;

    @JsonProperty("contract_number")
    private String contractNumber;

    @JsonProperty("contract_sum")
    private Long contractSum;

    @JsonProperty("contract_text")
    @Column(columnDefinition = "TEXT")
    private String contractText;

    @JsonProperty("contract_type")
    private String contractType;

    @JsonProperty("customer_name")
    @Column(columnDefinition = "TEXT")
    private String customerName;

    @JsonProperty("customer_tin")
    private Long customerTin;

    @JsonProperty("exucutor_name")
    @Column(columnDefinition = "TEXT")
    private String exucutorName;

    @JsonProperty("exucutor_tin")
    private Long exucutorTin;

    @JsonProperty("facture_date")
    private String factureDate;

    @JsonProperty("facture_number")
    private String factureNumber;

    @JsonProperty("facture_sum")
    private Long factureSum;

    @JsonProperty("lot_number")
    private Long lotNumber;

    @JsonProperty("vat_sum")
    private Long vatSum;

    @JsonProperty("with_vat_sum")
    private Long withVatSum;
}
