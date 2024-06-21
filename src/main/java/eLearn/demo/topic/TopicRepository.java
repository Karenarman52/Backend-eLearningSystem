package eLearn.demo.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    @Query("SELECT t FROM Topic t WHERE t.module.moduleId = ?1")
    List<Topic> getAllTopicsInModule(long moduleId);
}
