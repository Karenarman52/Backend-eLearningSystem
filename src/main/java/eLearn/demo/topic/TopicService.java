package eLearn.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicService {
    private TopicRepository topicRepository;
    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public List<Topic> getAllTopic(){
        return  topicRepository.findAll();
    }
    public List<Topic> getAllTopicInModule(long moduleId){

        return  topicRepository.getAllTopicsInModule(moduleId);
    }
}
