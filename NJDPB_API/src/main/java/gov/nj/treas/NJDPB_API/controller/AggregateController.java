package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.AggregateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/details")
public class AggregateController {

    @Autowired
    private AggregateServiceImpl aggregateService;

    @PostMapping("/details")
    public ResponseEntity<?> getDetails(@RequestBody AggregateRequestDTO aggregateRequestDTO){

        AggregateResponseDTO aggregateResponseDTO = aggregateService.findDetails(aggregateRequestDTO);

        return ResponseEntity.ok(aggregateResponseDTO);
    }
}
