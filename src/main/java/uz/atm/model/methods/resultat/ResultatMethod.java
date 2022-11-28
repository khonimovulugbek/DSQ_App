package uz.atm.model.methods.resultat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import uz.atm.model.base.Auditable;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonIgnoreProperties
@Table(indexes = {
        @Index(name = "resultat_method_lot_id_index", columnList = "lotId"),
        @Index(name = "resultat_method_procId_index", columnList = "procId"),
        @Index(name = "resultat_method_vendor_terr_index", columnList = "vendorTerr"),
        @Index(name = "resultat_method_contract_num_index", columnList = "contractNum")

})
public class ResultatMethod extends Auditable {

    @Column(name = "etp_id")
    @JsonProperty("ETP_ID")
    private Long etp_id;

    @JsonProperty("REQUEST_ID")
    private Long request_id;

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @Embedded
    @JsonProperty("PAYLOAD")
    private Payload payload;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class Payload {
        @JsonProperty("LOTID")
        private Long lotId;
        @JsonProperty("PROC_ID")
        private Integer procId;

        @JsonProperty("LOTDATE1")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date lotDate1;

        @Transient
        @JsonProperty("LOTDATES1")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date lotDates1;

        @Transient
        @JsonProperty("vendor_terr_name")
        private String vendorTerrName;

        @Transient
        @JsonProperty("LOTDATES2")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date lotDates2;

        @JsonProperty("LOTDATE2")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date lotDate2;


        @JsonProperty("CONTRACTNUM")
        private String contractNum;


        @JsonProperty("CONTRACTDAT")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractDat;

        @Transient
        @JsonProperty("CONTRACTDATS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date contractSDat;

        @JsonProperty("DVR")
        private Integer dvr;
        @JsonProperty("ORGAN")
        private String organ;

        @Transient
        @JsonProperty("ORGAN_NAME")
        private String organName;

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
        @Column(name = "p_summa")
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


        @Transient
        @JsonProperty("CONTRACTBEGS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date contractsBeg;

        public Date getContractsBeg() {
            return contractBeg;
        }

        public Date getContractsEnd() {
            return contractEnd;
        }

        public Date getLotDates1() {
            return lotDate1;
        }

        public Date getLotDates2() {
            return lotDate2;
        }

        @JsonProperty("CONTRACTEND")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractEnd;

        @Transient
        @JsonProperty("CONTRACTENDS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date contractsEnd;

        public Date getContractSDat() {
            return contractDat;
        }

        @JsonProperty("PURPOSE")
        @Column(columnDefinition = "TEXT")
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
        @OneToMany(cascade = CascadeType.ALL)
        private List<FinSrc> finsrc;
        //    @Embedded
        @OneToMany(cascade = CascadeType.ALL)
        @JsonProperty("SPECIFICATIONS")
        private List<Specifications> specifications;
        //    @Embedded
        @JsonProperty("GRAFICS")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Grafics> grafics;

        @JsonProperty("LINKS")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Links> links;

    }
}
