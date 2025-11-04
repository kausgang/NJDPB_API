package gov.nj.treas.NJDPB_API.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateRequestDTO {

    @NotBlank(message = "SSN must be entered")
    private String ssn;
}