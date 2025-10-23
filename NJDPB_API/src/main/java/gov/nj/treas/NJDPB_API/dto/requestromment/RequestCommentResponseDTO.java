package gov.nj.treas.NJDPB_API.dto.requestromment;

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
public class RequestCommentResponseDTO implements Serializable {

//    private ProcessedRequestId

//    private Integer comment_id;
//    private String ssn;
    private Integer request_id;
//
//    // Done by Itunuoluwa dbo.request_comment
//    private String user_id;
    private LocalDateTime comment_date;
    private String req_comment;

}
