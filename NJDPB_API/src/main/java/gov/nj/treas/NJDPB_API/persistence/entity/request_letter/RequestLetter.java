package gov.nj.treas.NJDPB_API.persistence.entity.request_letter;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "REQUEST_LETTER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestLetter {

    @EmbeddedId
    private RequestLetterId requestLetterId;

    private Integer letter_code;
    private LocalDateTime date_sent;
    private LocalDateTime date_received;
    private Integer letter_count;
    private Character expired;
    private String empr_loc;

}
