package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.ProcessedResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface ProcessedRequestService {

//    List<ProcessedResponseDTO> getProcessedRequestBySsn(ProcessedRequestDTO processedRequestDTO);
//    List<ProcessedResponseDTO> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO);
    CompletableFuture<List<ProcessedResponseDTO>> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO);
}
