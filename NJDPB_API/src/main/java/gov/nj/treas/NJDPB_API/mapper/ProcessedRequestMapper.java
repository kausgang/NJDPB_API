package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessedRequestMapper {

    @Mapping(source="processedRequestId.ssn",target="ssn")
    @Mapping(source = "processedRequestId.request_id", target = "request_id")
    ProcessedRequestResponseDTO toResponseDTO(ProcessedRequest processedRequest);

    List<ProcessedRequestResponseDTO> toResponseDTOList(List<ProcessedRequest> processedRequestList);
}