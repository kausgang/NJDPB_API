package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;

import java.util.List;


public interface AggregateService {

    AggregateResponseDTO findDetails(AggregateRequestDTO aggregateRequestDTO);
}
