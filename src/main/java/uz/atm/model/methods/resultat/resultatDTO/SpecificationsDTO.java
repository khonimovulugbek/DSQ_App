package uz.atm.model.methods.resultat.resultatDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.methods.resultat.Note;
import uz.atm.model.methods.resultat.Properties;
import uz.atm.model.methods.resultat.Split;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecificationsDTO {

    @JsonProperty("FINYEAR")
    private Integer  finYear;

    @JsonProperty("KLS")
    private String kls;

    @JsonProperty("NPOS")
    private Integer npos;

    @JsonProperty("TOVAR")
    private String tovar;

    @JsonProperty("TOVARNAME")
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
    private String note;
//    private List<NoteDTO> note;


    private List<Note> notes;

    public List<Note> setNotes(String notes) {
        Note noteResult = new Note();
        noteResult.setTechSpec(notes);
        return Collections.singletonList(noteResult);
    }

    @JsonProperty("SPLIT")
    private List<Split> split;

    @JsonProperty("PROPERTIES")
    private List<Properties> properties;

}
