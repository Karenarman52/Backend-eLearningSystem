package eLearn.demo.login;

import eLearn.demo.student.Student;
import eLearn.demo.student.StudentRepository;
import eLearn.demo.teacher.Teacher;
import eLearn.demo.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;


    @Autowired
    public LoginService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
    public ResponseEntity<?> studentLogin(Login login){
        Student existsStudent = studentRepository.findStudentByEmailForLogin(login.getEmailPhone());


        if (existsStudent != null && existsStudent.getStudentPassword().equals(login.getPassword())) {

            return ResponseEntity.ok().body("Welcome");

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Oops! It seems like your username or password is incorrect. Please try again.");
        }
    }
}
