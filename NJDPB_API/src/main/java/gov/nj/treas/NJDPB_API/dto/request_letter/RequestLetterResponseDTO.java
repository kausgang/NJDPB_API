package gov.nj.treas.NJDPB_API.dto.request_letter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestLetterResponseDTO {


    private String ssn;
    private Integer request_id;
    private Long letter_id;
    private Integer letter_code;
    private LocalDateTime date_sent;
    private LocalDateTime date_received;
    private Integer letter_count;
    private Character expired;
    private String empr_loc;
}
