package gov.nj.treas.NJDPB_API.persistence.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
//@EqualsAndHashCode
@Builder
public class ProcessedRequestId implements Serializable {


    private String ssn;
    private Integer request_id;



}
