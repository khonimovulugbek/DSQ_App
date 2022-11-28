package uz.atm.model.methods.resultat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("MARKA")
    private String marka;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("TECHSPEC")
    private String techSpec;

    @JsonProperty("MANUFACTURER")
    private String manufacturer;
    @JsonProperty("COUNTRY")
    private String country;

    @JsonProperty("GARANT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date garant;

    @Transient
    @JsonProperty("GARANTS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date garants;

    public Date getGarants() {
        return garant;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    @JsonProperty("GODIZG")
    private Date godIzg;

    @Transient
    @JsonProperty("GODIZGS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date godIzgs;

    public Date getGodIzgs() {
        return godIzg;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    @JsonProperty("SROKGOD")
    private Date spokGod;

    @Transient
    @JsonProperty("SROKGODS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date spokGods;

    public Date getSpokGods() {
        return spokGod;
    }

    @JsonProperty("LICENSE")
    private String license;
}