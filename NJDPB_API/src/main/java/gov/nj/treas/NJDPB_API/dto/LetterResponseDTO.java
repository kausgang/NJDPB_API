package gov.nj.treas.NJDPB_API.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LetterResponseDTO {

    private String letter_id;
    private String ssn;
    private String letter_type;
}
