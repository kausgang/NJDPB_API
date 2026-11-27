package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

//    List<Comment> findBySsn(String ssn);


    @Query("""
        SELECT c
        FROM Comment c
        WHERE c.ssn = :ssn
        ORDER BY c.comment_id DESC
    """)
    List<Comment> findBySsn(@Param("ssn") String ssn);

//    List<Comment> findBySsn(String ssn, Sort sort);

//    List<Comment> findBySsnOrderByCommentDateDesc(String ssn);
//    List<Comment> findBySsnOrderByComment_dateDesc(String ssn);

}
