package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter,Integer> {

//    List<Letter> findBySsn(String ssn);

    @Query("""
        SELECT l
        FROM Letter l
        WHERE l.ssn = :ssn
        ORDER BY l.id DESC
    """)
    List<Letter> findBySsn(String ssn);
}
