package gov.nj.treas.NJDPB_API.dto.processed_request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedRequestResponseDTO {

    private String ssn;
    private Integer request_id;

    private LocalDateTime request_date;
    private Integer status_code;
    private LocalDateTime purchase_begin_date;
    private LocalDateTime purchase_end_date;
    private String calcby_userid;
    private String retired;
    private String terminated;
    private String high_priority;
}
