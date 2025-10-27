package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequestId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//public interface ProcessedRequestRepository extends JpaRepository<ProcessedRequest, ProcessedRequestId> {
public interface ProcessedRequestRepository extends JpaRepository<ProcessedRequest, String> {

//    List<ProcessedRequest> findByProcessedRequestIdSsn(String ssn);

    List<ProcessedRequest> findBySsn(String ssn);
}
