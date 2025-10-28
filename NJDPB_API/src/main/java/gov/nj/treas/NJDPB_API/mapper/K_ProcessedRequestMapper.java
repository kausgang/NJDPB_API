package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.processedRequest.K_ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.K_ProcessedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface K_ProcessedRequestMapper {

//    ProcessedRequest toEntity(ProcessedRequestDTO processedRequestDTO);

    @Mapping(source="processedRequestId.ssn",target="ssn")
    @Mapping(source = "processedRequestId.request_id", target = "request_id")
    K_ProcessedResponseDTO toResponseDTO(K_ProcessedRequest processedRequest);

    List<K_ProcessedResponseDTO> toResponseDTOList(List<K_ProcessedRequest> processedRequestList);
}
