package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.MSSChecklistResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.MSSChecklist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MSSChecklistMapper {


    MSSChecklistResponseDTO toResponse(MSSChecklist mssChecklist);
}
