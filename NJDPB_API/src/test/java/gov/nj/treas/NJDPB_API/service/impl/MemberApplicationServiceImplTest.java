package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.MemberApplicationMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberApplicationRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MemberApplicationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MemberApplicationServiceImplTest {

    @Mock
    MemberApplicationRepository memberApplicationRepository;

    @Mock
    MemberApplicationMapper memberApplicationMapper;

    @InjectMocks
    MemberApplicationServiceImpl memberApplicationService;

    private AggregateRequestDTO aggregateRequest;
    private MemberApplication memberApplication;
    private MemberApplicationResponseDTO memberApplicationDTO;


    @BeforeEach
    void setUp() {

        aggregateRequest = AggregateRequestDTO.builder().ssn("123456789").build();
        memberApplication = MemberApplication.builder().ssnMember("123456789").build();
        memberApplicationDTO = MemberApplicationResponseDTO.builder()
                .idn_member_num(1)
                .ssnMember("123456789")
                .build();

        
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMemberApplicationBySsn() throws ExecutionException, InterruptedException, TimeoutException {


        String ssn = aggregateRequest.getSsn();
        List<MemberApplication> memberApplicationList = Collections.singletonList(memberApplication);
        Mockito.when(memberApplicationRepository.findBySsnMember(ssn)).thenReturn(memberApplicationList);

        List<MemberApplicationResponseDTO> memberApplicationDTOList = Collections.singletonList(memberApplicationDTO);
        Mockito.when(memberApplicationMapper.toResponseDTOList(memberApplicationList))
                .thenReturn(memberApplicationDTOList);


        CompletableFuture<List<MemberApplicationResponseDTO>> futureResponse  =  memberApplicationService.getMemberApplicationBySsn(aggregateRequest);

        // 4. Extract the result from the CompletableFuture and Assert
        List<MemberApplicationResponseDTO> actualResponseDTOList = futureResponse.get(2, TimeUnit.SECONDS);

        assertEquals(1,actualResponseDTOList.size());
        assertEquals("123456789",actualResponseDTOList.getFirst().getSsnMember());
    }
}