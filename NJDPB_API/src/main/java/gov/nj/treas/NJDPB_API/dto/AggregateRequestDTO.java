package gov.nj.treas.NJDPB_API.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about a member", example = "{\"ssn\": \"123456789\"}")
public class AggregateRequestDTO {

    @Schema(description = "SSN number of the member", example = "123456789",  type = "string")
    private String ssn;
}
