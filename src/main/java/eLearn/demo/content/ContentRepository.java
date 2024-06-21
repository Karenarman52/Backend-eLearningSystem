package eLearn.demo.content;

import eLearn.demo.subtopic.Subtopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentRepository  extends JpaRepository<Content,Long> {
    @Query("SELECT c FROM Content c WHERE c.subtopic.subtopicId= ?1")
    List<Content> getAllContentInSubtopic(long subtopicId);
}
