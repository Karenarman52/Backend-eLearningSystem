package eLearn.demo.subtopic;

import eLearn.demo.module.Module;
import eLearn.demo.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtopicRepository extends JpaRepository<Subtopic,Long> {
    @Query("SELECT s FROM Subtopic s WHERE s.topic.topicId= ?1")
    List<Subtopic> getAllSubtopicsInTopic(long topicId);
}
