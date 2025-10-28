package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.processedRequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessedRequestMapper {

//    ProcessedRequest toEntity(ProcessedRequestDTO processedRequestDTO);

    @Mapping(source="processedRequestId.ssn",target="ssn")
    @Mapping(source = "processedRequestId.request_id", target = "request_id")
    ProcessedResponseDTO toResponseDTO(ProcessedRequest processedRequest);

    List<ProcessedResponseDTO> toResponseDTOList(List<ProcessedRequest> processedRequestList);
}
