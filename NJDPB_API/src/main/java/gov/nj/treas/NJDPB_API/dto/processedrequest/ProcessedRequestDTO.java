package gov.nj.treas.NJDPB_API.dto.processedrequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Schema(description = "Details about a member", example = "{\"ssn\": \"123456789\"}")
public class ProcessedRequestDTO {

    private String ssn;
    private Integer request_id;
    private LocalDateTime request_date;
}
