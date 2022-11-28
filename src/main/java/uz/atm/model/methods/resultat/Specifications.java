package uz.atm.model.methods.resultat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Specifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("FINYEAR")
    private Integer finYear;
    @JsonProperty("KLS")
    private String kls;
    @JsonProperty("NPOS")
    private Integer npos;
    @JsonProperty("TOVAR")
    private String tovar;
    @JsonProperty("TOVARNAME")
    @Column(columnDefinition = "TEXT")
    private String tovarName;
    @JsonProperty("TOVARNOTE")
    private String tovarNote;
    @JsonProperty("TOVAREDIZM")
    private String tovarEdizm;
    @JsonProperty("TOVARAMOUNT")
    private Long tovarAmount;
    @JsonProperty("TOVARPRICE")
    private Long tovarPrice;
    @JsonProperty("TOVARSUMMA")
    private Long tovarSumma;
    @JsonProperty("EXPENSE")
    private Long expense;

    @JsonProperty("NOTE")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Note> note;


    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("SPLIT")
    private List<Split> split;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("PROPERTIES")
    private List<Properties> properties;
}