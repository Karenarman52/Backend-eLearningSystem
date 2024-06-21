package eLearn.demo.content;

import eLearn.demo.subtopic.Subtopic;
import eLearn.demo.subtopic.SubtopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "elearning/contents")
public class ContentController {

    private ContentService contentService;
    public ContentController(ContentService contentService){
        this.contentService=contentService;
    }
    @GetMapping("/all")
    public List<Content> getAllContent(){
        return contentService.getAllContent();
    }
    @GetMapping("/content/{contentId}")
    public List<Content> getAllContentInSubtopic(@PathVariable Long subtopicid){
        return  contentService.getAllContentInSubtopic(subtopicid);
    }
}
