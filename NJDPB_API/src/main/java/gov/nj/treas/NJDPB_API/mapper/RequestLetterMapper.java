package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.request_letter.RequestLetterResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.request_letter.RequestLetter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestLetterMapper {

    @Mapping(source = "requestLetterId.ssn" , target = "ssn")
    @Mapping(source = "requestLetterId.request_id" , target = "request_id")
    @Mapping(source = "requestLetterId.letter_id" , target = "letter_id")
    RequestLetterResponseDTO toResponseDTO(RequestLetter requestLetter);

    List<RequestLetterResponseDTO> toResponseDTOList(List<RequestLetter> requestLetterList);

}
