package eLearn.demo.subtopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtopicRepository extends JpaRepository<Subtopic,Long> {
    @Query("SELECT s FROM Subtopic s WHERE s.topic.topicId= ?1")
    List<Subtopic> getAllSubtopicsInTopic(long topicId);
}
