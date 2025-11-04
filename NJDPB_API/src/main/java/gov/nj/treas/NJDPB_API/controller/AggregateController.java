package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.service.intrface.AggregateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AggregateController {

    private final AggregateService aggregateService;

    @PostMapping("/details")
    public ResponseEntity<?> getDetails(@Valid @RequestBody AggregateRequestDTO aggregateRequestDTO) throws Exception{

        AggregateResponseDTO aggregateResponseDTO = aggregateService.findDetails(aggregateRequestDTO);

        return ResponseEntity.ok(aggregateResponseDTO);
    }
}