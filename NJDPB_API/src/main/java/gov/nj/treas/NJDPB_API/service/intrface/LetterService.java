package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface LetterService {

    CompletableFuture<List<LetterResponseDTO>> getLetterBySsn(AggregateRequestDTO aggregateRequestDTO);
}
