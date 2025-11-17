package gov.nj.treas.NJDPB_API.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LetterResponseDTO {

    private Integer id;

    private String ssn;
    private LocalDateTime prtdate;
    private String sentby;
    private Integer type;
}
