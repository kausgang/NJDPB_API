package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.K_ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.K_ProcessedRequestServiceImpl;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/processed_request")
@Tag(name = "Processed Request")
@RequiredArgsConstructor
public class K_ProcessedRequestController {


//    @Autowired
//    private final ProcessedRequestService processedRequestService;

    private final K_ProcessedRequestServiceImpl k_ProcessedRequestService;


    @Operation(
            summary = "Find Procces Request by SSN",
            description = "Retrieves Processed Request information based on provided SSN number",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved member information",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProcessedResponseDTO.class))
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
    @PostMapping("/K_find_by_ssn")
//    public ResponseEntity<?> findBySsn(@RequestBody ProcessedRequestDTO processedRequestDTO){
    public ResponseEntity<?> findBySsn(@Valid @RequestBody AggregateRequestDTO processedRequestDTO) {


        List<K_ProcessedResponseDTO> response = k_ProcessedRequestService.getProcessedRequestBySsn(processedRequestDTO);

        return ResponseEntity.ok(response);
    }
}



