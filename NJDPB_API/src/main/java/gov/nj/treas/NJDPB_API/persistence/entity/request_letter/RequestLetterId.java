package gov.nj.treas.NJDPB_API.persistence.entity.request_letter;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class RequestLetterId implements Serializable {

    private String ssn;
    private Integer request_id;
    private Long letter_id;
}
