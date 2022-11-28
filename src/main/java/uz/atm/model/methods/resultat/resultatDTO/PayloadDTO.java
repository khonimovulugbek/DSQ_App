package uz.atm.model.methods.resultat.resultatDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;
import uz.atm.model.methods.resultat.FinSrc;
import uz.atm.model.methods.resultat.Grafics;
import uz.atm.model.methods.resultat.Links;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayloadDTO {

    @JsonProperty("LOTID")
    private Long lotId;

    @JsonProperty("PROC_ID")
    private Integer procId;

    @JsonProperty("LOTDATE1")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date lotDate1;

    @JsonProperty("LOTDATE2")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date lotDate2;

    @JsonProperty("CONTRACTNUM")
    private String contractNum;

    @JsonProperty("CONTRACTDAT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date contractDat;

    @JsonProperty("DVR")
    private Integer dvr;

    @JsonProperty("ORGAN")
    private String organ;

    @JsonProperty("INN")
    private String inn;

    @JsonProperty("LS")
    private String ls;

    @JsonProperty("VENDORNAME")
    private String vendorName;

    @JsonProperty("VENDORBANK")
    private String vendorBank;

    @JsonProperty("VENDORACC")
    private String vendorAcc;

    @JsonProperty("VENDORINN")
    private String vendorInn;

    @JsonProperty("MALOY")
    private String maloy;

    @JsonProperty("SUMMA")
    private Long summa;

    @JsonProperty("SUMNDS")
    private Long sumNds;

    @JsonProperty("SROK")
    private Integer spok;

    @Column(name = "p_avans")
    @JsonProperty("AVANS")
    private String avans;

    @JsonProperty("AVANSDAY")
    private Integer avansDay;

    @JsonProperty("CONTRACTBEG")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date contractBeg;

    @JsonProperty("CONTRACTEND")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date contractEnd;

    @JsonProperty("PURPOSE")
    private String purpose;

    @JsonProperty("VENDORTERR")
    private Integer vendorTerr;

    @JsonProperty("BENEFICIAR")
    private String beneficiar;

    @JsonProperty("RASCHOT")
    private Integer raschot;

    @JsonProperty("REESTR_ID")
    private Long reestrId;

    @JsonProperty("PNFL")
    private Long pnfl;

    @JsonProperty("VENDORCOUNTRY")
    private String vendorCountry;

    @JsonProperty("VENDORFORIEGIN")
    private String vendorForeign;

    @JsonProperty("VENDORINFO")
    private String vendorInfo;

    @JsonProperty("VENDORKLS")
    private String vendorKls;

    @JsonProperty("GEN_ID")
    private Long genId;

    @JsonProperty("CONTRACT_ID")
    private Long contractId;

    @JsonProperty("VERSION")
    private Integer version;
    //    @Embedded
    @JsonProperty("FINSRC")
    private List<FinSrc> finsrc;
    //    @Embedded

    @JsonProperty("SPECIFICATIONS")
    private List<SpecificationsDTO> specifications;
    //    @Embedded
    @JsonProperty("GRAFICS")
    private List<Grafics> grafics;

    @JsonProperty("LINKS")
    private List<Links> links;

}
