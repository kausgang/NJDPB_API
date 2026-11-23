package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.MSSChecklistResponseDTO;

import java.util.concurrent.CompletableFuture;

public interface MSSChecklistService {

    CompletableFuture<MSSChecklistResponseDTO> getMSSChecklist(AggregateRequestDTO aggregateRequestDTO);
}
