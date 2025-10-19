package gov.nj.treas.NJDPB_API.persistence.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PROCESSED_REQUEST")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedRequest {


//    @EmbeddedId
//    private ProcessedRequestId processedRequestId;


    @Id
    private String ssn;
    private Integer request_id;

    private LocalDateTime request_date;



}
