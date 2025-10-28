package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.K_ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequestId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface K_ProcessedRequestRepository extends JpaRepository<K_ProcessedRequest, ProcessedRequestId> {

    List<K_ProcessedRequest> findByProcessedRequestIdSsn(String ssn);

//    List<ProcessedRequest> findBySsn(String ssn);
}
