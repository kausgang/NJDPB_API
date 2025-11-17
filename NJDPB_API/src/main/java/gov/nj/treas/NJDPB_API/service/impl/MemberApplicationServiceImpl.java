package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.MemberApplicationMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberApplicationRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MemberApplicationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class MemberApplicationServiceImpl implements MemberApplicationService {

    private final MemberApplicationRepository memberApplicationRepository;
    private final MemberApplicationMapper memberApplicationMapper;


    @Override
    public CompletableFuture<List<MemberApplicationResponseDTO>> getMemberApplicationBySsn(AggregateRequestDTO aggregateRequestDTO) {

        try {
            String ssn = aggregateRequestDTO.getSsn();

            List<MemberApplication> memberApplicationList = memberApplicationRepository.findBySsnMember(ssn);

            if(memberApplicationList.isEmpty()) throw new RecordNotFoundException("MEMBER_APPLICATION - Record not found");

            List<MemberApplicationResponseDTO> memberApplicationResponseDTOList = memberApplicationMapper.toResponseDTOList(memberApplicationList);

            return CompletableFuture.completedFuture(memberApplicationResponseDTOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
