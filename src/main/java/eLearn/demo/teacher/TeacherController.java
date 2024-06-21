package eLearn.demo.teacher;

import eLearn.demo.student.Student;
import eLearn.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "elearningV2/teachers/")
public class TeacherController {
    private Teacherservice teacherservice;
    @Autowired
    public TeacherController(Teacherservice teacherservice) {
        this.teacherservice = teacherservice;
    }

    @GetMapping(path = "/allTeachers/")
    public List<Teacher> getAllTeacher(){
        return teacherservice.getAllTeachers();
    }

    @PostMapping(path = "/registerStudent")
    public ResponseEntity<Teacher> registerTeacher(@RequestBody Teacher teacher){
        return teacherservice.registerTeacher(teacher);
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
