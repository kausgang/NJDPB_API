package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.requestromment.RequestCommentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestCommentService {

//    List<ProcessedResponseDTO> getProcessedRequestBySsn(ProcessedRequestDTO processedRequestDTO);
List<RequestCommentResponseDTO> getRequestCommentBySsn(AggregateRequestDTO aggregateRequestDTO);
}
