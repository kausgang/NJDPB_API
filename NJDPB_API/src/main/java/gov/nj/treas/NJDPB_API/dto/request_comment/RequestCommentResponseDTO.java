package gov.nj.treas.NJDPB_API.dto.request_comment;

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
public class RequestCommentResponseDTO {

    private Integer comment_id;
    private String ssn;
    private Integer request_id;
    private String user_id;
    private LocalDateTime comment_date;
    private String req_comment;

}