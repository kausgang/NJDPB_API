package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO_v2;

import java.util.concurrent.ExecutionException;

public interface AggregateService_v2 {

    AggregateResponseDTO_v2 findDetails(AggregateRequestDTO aggregateRequestDTO) throws ExecutionException, InterruptedException;
}
