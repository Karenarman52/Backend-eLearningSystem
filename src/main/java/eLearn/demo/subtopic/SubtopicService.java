package eLearn.demo.subtopic;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtopicService {
    private SubtopicRepository subtopicRepository;

    public SubtopicService(SubtopicRepository subtopicRepository){
        this.subtopicRepository=subtopicRepository;
    }
    public List<Subtopic> getAllSubtopic(){
       return subtopicRepository.findAll();
    }
    public List<Subtopic> getAllSubtopicInTopic(long topicId){
        return subtopicRepository.getAllSubtopicsInTopic(topicId);

    }
}
