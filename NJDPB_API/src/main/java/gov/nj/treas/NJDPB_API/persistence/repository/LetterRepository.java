package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {

    List<Letter> findBySsn(Long ssn);

}
