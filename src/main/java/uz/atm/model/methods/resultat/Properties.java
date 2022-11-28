package uz.atm.model.methods.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Embeddable
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("PROP_NUMB")
	private Integer propNumb;
	@JsonProperty("PROP_NAME")
	private String propName;
	@JsonProperty("VAL_NUMB")
	private Integer valNumb;
	@JsonProperty("VAL_NAME")
	private String valName;
}