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
public class CommentResponseDTO {

    private Integer comment_id;

    private String ssn;
    private String user_id;
    private LocalDateTime comment_date;
    private String comments;
}
