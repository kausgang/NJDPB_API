package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.request_letter.RequestLetter;
import gov.nj.treas.NJDPB_API.persistence.entity.request_letter.RequestLetterId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestLetterRepository extends JpaRepository<RequestLetter, RequestLetterId> {

    List<RequestLetter> findByRequestLetterIdSsn(String ssn);
}
