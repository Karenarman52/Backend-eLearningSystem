package eLearn.demo.subtopic;

import eLearn.demo.topic.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "elearning/subtopics")
public class SubtopicController {
    private SubtopicService subtopicService;
    public SubtopicController(SubtopicService subtopicService){
        this.subtopicService=subtopicService;
    }
    @GetMapping("/all")
    public List<Subtopic> getAllSubtopic(){
        return subtopicService.getAllSubtopic();
    }
    @GetMapping("/topic/{topicId}")
    public List<Subtopic> getAllSubtopicInTopic(@PathVariable Long topicId){
        return  subtopicService.getAllSubtopicInTopic(topicId);
    }
}
