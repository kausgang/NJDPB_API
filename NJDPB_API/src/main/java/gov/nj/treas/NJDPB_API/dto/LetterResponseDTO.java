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

    private Long id;
    private Long IDN_MEMBER_NUM;
    private Long ssn;
    private String FIELD1;
}
