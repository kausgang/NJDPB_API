package gov.nj.treas.NJDPB_API.dto.processedRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Schema(description = "Details about a member", example = "{\"ssn\": \"123456789\"}")
public class ProcessedRequestDTO {

    private String ssn;

}
