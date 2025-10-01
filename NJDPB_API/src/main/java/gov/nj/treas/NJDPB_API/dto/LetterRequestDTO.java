package gov.nj.treas.NJDPB_API.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LetterRequestDTO {

    @NotBlank(message = "SSN cannot be blank")
    private String ssn;
//    public String getSsn(){
//        return ssn;
//    }
}
