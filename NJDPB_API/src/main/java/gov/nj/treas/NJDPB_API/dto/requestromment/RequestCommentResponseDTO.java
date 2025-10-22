package gov.nj.treas.NJDPB_API.dto.requestromment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCommentResponseDTO implements Serializable {

//    private ProcessedRequestId

    private Integer comment_id;
    private String ssn;
    private Integer request_id;


}
