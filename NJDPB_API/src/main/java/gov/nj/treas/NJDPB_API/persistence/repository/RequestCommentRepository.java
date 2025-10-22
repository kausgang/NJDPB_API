package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.Calculation;
import gov.nj.treas.NJDPB_API.persistence.entity.RequestComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestCommentRepository extends JpaRepository<RequestComment, Integer> {

//    List<ProcessedRequest> findByProcessedRequestIdSsn(String ssn);

    List<RequestComment> findBySsn(String ssn);
}
