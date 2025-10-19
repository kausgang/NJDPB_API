package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessedRequestMapper {

    ProcessedRequest toEntity(ProcessedRequestDTO processedRequestDTO);

    ProcessedResponseDTO toResponseDTO(ProcessedRequest processedRequest);

    List<ProcessedResponseDTO> toResponseDTOList(List<ProcessedRequest> processedRequestList);
}
