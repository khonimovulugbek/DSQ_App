package uz.atm.model.methods.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class FinSrc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "f_npos")
	@JsonProperty("NPOS")
	private Integer npos;
	@Column(name = "f_kls")
	@JsonProperty("KLS")
	private String kls;
	@JsonProperty("BANKCODE")
	private Integer bankCode;
	@JsonProperty("BANKACC")
	private String bankAcc;
	@Column(name = "f_summa")
	@JsonProperty("SUMMA")
	private Long summa;
	@Column(name = "f_avans")
	@JsonProperty("AVANS")
	private String avans;
}
