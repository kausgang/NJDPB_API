package gov.nj.treas.NJDPB_API.dto.processedrequest;

import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequestId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedResponseDTO {

//    private ProcessedRequestId

    private String ssn;
    private Integer request_id;
    private LocalDateTime request_date;

}
