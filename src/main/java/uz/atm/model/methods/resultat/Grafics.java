package uz.atm.model.methods.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grafics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("FINYEAR")
    private Integer finyear;

    @JsonProperty("MONTH")
    private Integer month;

    @JsonProperty("KLS")
    private String kls;

    @JsonProperty("TOVARSUMMA")
    private Long tovarsumma;

    @JsonProperty("EXPENSE")
    private Integer expense;

    @JsonProperty("AVANS")
    private Long avans;

    @JsonProperty("SUMMA")
    private Long summa;

    @JsonProperty("RETSUMMA")
    private Long retSumma;

}