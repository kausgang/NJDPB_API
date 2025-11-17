package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberApplicationRepository extends JpaRepository<MemberApplication,Integer> {

    List<MemberApplication> findBySsnNumber(String ssn);
}
