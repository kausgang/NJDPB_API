package gov.nj.treas.NJDPB_API.dto.processedrequest;

import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequestId;
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
public class ProcessedResponseDTO implements Serializable {

//    private ProcessedRequestId

//    private String ssn;
    private Integer request_id;
    private LocalDateTime request_date;
//
//
//    //Done by Itunuoluwa for dbo.Processed_request
    private Integer status_code;
//    private LocalDateTime processed_date;
//    private Integer purchase_code;
    private LocalDateTime purchase_begin_date;
    private LocalDateTime purchase_end_date;
    private String calcby_userid;
//    private String enterby_userid;
    private String retired;
    private String terminated;
    private String high_priority;
//    private LocalDateTime date_entered;

}
