package gov.nj.treas.NJDPB_API.service.impl;


import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.MSSChecklistResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.MSSChecklistMapper;
import gov.nj.treas.NJDPB_API.persistence.repository.MSSChecklistRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MSSChecklistService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class MSSChecklistImpl implements MSSChecklistService {


//    private final MSSChecklistService mssChecklistService;
    private final MSSChecklistRepository mssChecklistRepository;
    private final MSSChecklistMapper MSSChecklistMapper;

    @Override
    public CompletableFuture<MSSChecklistResponseDTO> getMSSChecklist(AggregateRequestDTO aggregateRequestDTO) {
//        return null;


        try {
            String ssn = aggregateRequestDTO.getSsn();

            String retirement_type = mssChecklistRepository.findRetirementTypeBySsn(ssn);

            System.out.println("retirement type = " + retirement_type);

//            MSSChecklistResponseDTO mssChecklistResponseDTO = MSSChecklistMapper.toResponse(retirement_type);

//            System.out.println("mapper output = " + mssChecklistResponseDTO.toString());

            MSSChecklistResponseDTO mssChecklistResponseDTO = MSSChecklistResponseDTO.builder()
                    .retirement_type(retirement_type)
                    .build();

            return CompletableFuture.completedFuture(mssChecklistResponseDTO);

        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
