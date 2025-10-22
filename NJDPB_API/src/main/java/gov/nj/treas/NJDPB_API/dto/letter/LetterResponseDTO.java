package gov.nj.treas.NJDPB_API.dto.letter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LetterResponseDTO implements Serializable {

    private Integer letter_id;
    private Integer letter_type;
    private String ssn;




}
