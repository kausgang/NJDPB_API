package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.AggregateServiceImpl;
import gov.nj.treas.NJDPB_API.service.intrface.AggregateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/details")
@RequiredArgsConstructor
@Tag(name = "Aggregate Response")
public class AggregateController {

//    @Autowired
//    private AggregateServiceImpl aggregateService;

    private final AggregateService aggregateService;



    @Operation(
            summary = "Find members by SSN",
            description = "Retrieves member information based on provided SSN number",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved member information",
                            content = @Content(
                                    mediaType = "application/json",
//                                    array = @ArraySchema(schema = @Schema(implementation = AggregateResponseDTO.class))
                                    schema = @Schema(implementation = AggregateResponseDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request - invalid SSN or processing error",
                            content = @Content
                    )
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
    public ResponseEntity<?> getDetails(@Valid @RequestBody AggregateRequestDTO aggregateRequestDTO){

        AggregateResponseDTO aggregateResponseDTO = aggregateService.findDetails(aggregateRequestDTO);

        return ResponseEntity.ok(aggregateResponseDTO);
    }
}
