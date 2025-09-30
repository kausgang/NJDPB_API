package gov.nj.treas.NJDPB_API.service.intrface;



import gov.nj.treas.NJDPB_API.dto.LetterRequestDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;

import java.util.List;

public interface LetterService {

    List<LetterResponseDTO> getLetterBySSN(LetterRequestDTO letterRequestDTO);
}
