package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.K_ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface K_ProcessedRequestService {

//    List<ProcessedResponseDTO> getProcessedRequestBySsn(ProcessedRequestDTO processedRequestDTO);
List<K_ProcessedResponseDTO> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO);
}
