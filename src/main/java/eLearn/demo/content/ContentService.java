package eLearn.demo.content;

import eLearn.demo.subtopic.Subtopic;
import eLearn.demo.subtopic.SubtopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    private ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository){
        this.contentRepository=contentRepository;
    }
    public List<Content> getAllContent(){
        return contentRepository.findAll();
    }
    public List<Content> getAllContentInSubtopic(long subtopicId){
        return contentRepository.getAllContentInSubtopic(subtopicId);

    }
}
