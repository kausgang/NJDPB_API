package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProcessedRequestService {

//    List<ProcessedResponseDTO> getProcessedRequestBySsn(ProcessedRequestDTO processedRequestDTO);
List<ProcessedResponseDTO> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO);
}
