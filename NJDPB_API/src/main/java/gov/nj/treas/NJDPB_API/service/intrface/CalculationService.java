package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalculationService {

//    List<ProcessedResponseDTO> getProcessedRequestBySsn(ProcessedRequestDTO processedRequestDTO);
List<CalculationResponseDTO> getCalculationBySsn(AggregateRequestDTO aggregateRequestDTO);
}
