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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("FILENAME")
    private String fileName;
    @JsonProperty("LINK")
    private String linkDoc;
}