package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper;
import gov.nj.treas.NJDPB_API.service.intrface.AggregateService;
import gov.nj.treas.NJDPB_API.service.intrface.MemberService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AggregateServiceImpl implements AggregateService {

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private ProcessedRequestServiceImpl processedRequestService;

    @Autowired
    private AggregateMapper aggregateMapper;

    @Override
    @Transactional
    public AggregateResponseDTO findDetails(AggregateRequestDTO aggregateRequestDTO) {


        log.info("received Aggregate Request Object {}",aggregateRequestDTO);

        log.debug("Calling Member Service");
        List<MemberResponseDTO> members = memberService.getMembersBySsn(aggregateRequestDTO);
        log.debug("Retrieved Members = {}",members);
//        return List.of();

        log.debug("Calling ProcessedRequest Service");
        List<ProcessedResponseDTO> processed_requests = processedRequestService.getProcessedRequestBySsn(aggregateRequestDTO);
        log.debug("Retrieved ProcessedRequests = {}",processed_requests);


        return aggregateMapper.toAggregateResponseDto(members,processed_requests);

    }
}
