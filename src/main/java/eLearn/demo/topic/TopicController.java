package eLearn.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "eLearing/topics")
public class TopicController {
    private TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService){
        this.topicService=topicService;
    }
    @GetMapping("/all")
    public List<Topic> getAllTopic(){

        return  topicService.getAllTopic();
    }
    @GetMapping("/module/{moduleId}")
    public List<Topic> getAllTopicInModule(@PathVariable Long moduleId){
        return  topicService.getAllTopicInModule(moduleId);
    }
}
