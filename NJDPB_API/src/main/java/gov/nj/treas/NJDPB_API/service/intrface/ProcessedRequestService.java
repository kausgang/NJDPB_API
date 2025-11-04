package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProcessedRequestService {

    CompletableFuture<List<ProcessedRequestResponseDTO>> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO);
}