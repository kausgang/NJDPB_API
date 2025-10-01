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

    private String LETTER_ID;
    private String LETTER_TYPE;
//    private Long IDN_MEMBER_NUM;
    private String SSN;
//    private String FIELD1;
}
