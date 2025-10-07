package gov.nj.treas.NJDPB_API.service.intrface;



import gov.nj.treas.NJDPB_API.dto.letter.LetterRequestDTO;
import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;

import java.util.List;

public interface LetterService {

    List<LetterResponseDTO> getLetterBySSN(LetterRequestDTO letterRequestDTO);
}
