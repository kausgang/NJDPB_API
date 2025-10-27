package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.processedrequest.K_ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.K_ProcessedRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface K_ProcessedRequestMapper {

//    ProcessedRequest toEntity(ProcessedRequestDTO processedRequestDTO);

    K_ProcessedResponseDTO toResponseDTO(K_ProcessedRequest processedRequest);

    List<K_ProcessedResponseDTO> toResponseDTOList(List<K_ProcessedRequest> processedRequestList);
}
