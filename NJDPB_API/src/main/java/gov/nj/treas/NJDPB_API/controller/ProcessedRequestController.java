package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.ProcessedRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/processed_request")
public class ProcessedRequestController {


    @Autowired
    private ProcessedRequestServiceImpl processedRequestService;

    @PostMapping("/find_by_ssn")
//    public ResponseEntity<?> findBySsn(@RequestBody ProcessedRequestDTO processedRequestDTO){
    public ResponseEntity<?> findBySsn(@RequestBody AggregateRequestDTO processedRequestDTO) {


        List<ProcessedResponseDTO> response = processedRequestService.getProcessedRequestBySsn(processedRequestDTO);

        return ResponseEntity.ok(response);
    }
}



