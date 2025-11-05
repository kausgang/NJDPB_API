package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.request_letter.RequestLetterResponseDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface RequestLetterService {

    CompletableFuture<List<RequestLetterResponseDTO>> getRequestLetterBySsn(AggregateRequestDTO aggregateRequestDTO);
}
