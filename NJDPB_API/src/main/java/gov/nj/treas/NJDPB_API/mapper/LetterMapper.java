package gov.nj.treas.NJDPB_API.mapper;


import gov.nj.treas.NJDPB_API.dto.LetterRequestDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LetterMapper {

    Letter toEntity(LetterRequestDTO requestDTO);
    LetterResponseDTO toResponseDTO(Letter letter);
    List<LetterResponseDTO> toResponseDTOList(List<Letter> letters);
}
