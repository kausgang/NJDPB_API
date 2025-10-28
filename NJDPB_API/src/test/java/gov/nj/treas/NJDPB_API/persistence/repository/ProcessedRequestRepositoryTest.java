package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;


@DataJpaTest
class ProcessedRequestRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProcessedRequestRepository processedRequestRepository;


    @BeforeEach
    void setUp() {

//        ProcessedRequestId processedRequestId = ProcessedRequestId.builder()
//                .ssn("123456789")
//                .request_id(123456789)
//                .build();

//        ProcessedRequest processedRequest = ProcessedRequest.builder()
//                .processedRequestId(processedRequestId)
//                .build();

        ProcessedRequest processedRequest = ProcessedRequest.builder()
                .ssn("123456789")
                .request_id(123456789)
                .build();

        testEntityManager.persist(processedRequest);
        testEntityManager.flush();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByProcessedRequestIdSsn_ProcessedRequestFound() {

//        List<ProcessedRequest> processedRequestList = processedRequestRepository.findByProcessedRequestIdSsn("123456789");
        List<ProcessedRequest> processedRequestList = processedRequestRepository.findBySsn("123456789");

        Assertions.assertThat(processedRequestList).isNotEmpty();

    }
}