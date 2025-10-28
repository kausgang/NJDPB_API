package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Calculation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalculationMapper {

//    Calculation toEntity(rocessedRequestDTO processedRequestDTO);

    CalculationResponseDTO toResponseDTO(Calculation calculation);

    List<CalculationResponseDTO> toResponseDTOList(List<Calculation> calculationList);
}
