package gov.nj.treas.NJDPB_API.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "REQUEST_COMMENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestComment {


//    @EmbeddedId
//    private ProcessedRequestId processedRequestId;


    @Id
    private Integer comment_id;
    private String ssn;
    private Integer request_id;






}
