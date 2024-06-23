package eLearn.demo.subtopic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("topicId") Long topicId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get("/path/to/your/upload/directory/" + fileName); // Adjust the path as per your setup
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            // Create a new content object
            Subtopic content = new Subtopic();// Assuming this is how you determine the type
            // Set the URL for the file


            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to upload file");
        }
    }

    }








