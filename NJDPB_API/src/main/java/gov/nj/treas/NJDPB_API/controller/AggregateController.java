package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.ErrorResponseDTO;
import gov.nj.treas.NJDPB_API.service.intrface.AggregateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Aggregate Response", description = "Combine API responses from dbo.MEMBER, " +
        "dbo.PROCESSED_REQUEST," +
        "dbo.REQUEST_COMMENT," +
        "dbo.REQUEST_LETTER")
public class AggregateController {

    private final AggregateService aggregateService;

    @Operation(
            summary = "Find by SSN",
            description = "Retrieves Member, Processed Request, Request Comment & Request Letter information based on provided SSN number",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved information",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = AggregateResponseDTO.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request - invalid Input/SSN",
                            content = @Content(
                                    mediaType = "application/JSON",
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Record not found",
                            content = @Content(
                                    mediaType = "application/JSON",
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Member SSN information",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AggregateRequestDTO.class)
                    )
            )
    )
    @PostMapping("/details")
    public ResponseEntity<?> getDetails(@Valid @RequestBody AggregateRequestDTO aggregateRequestDTO) throws Exception{

        AggregateResponseDTO aggregateResponseDTO = aggregateService.findDetails(aggregateRequestDTO);

        return ResponseEntity.ok(aggregateResponseDTO);
    }
}