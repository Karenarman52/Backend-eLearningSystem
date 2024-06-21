package eLearn.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<Student> registerStudent(Student student){
        Optional<Student> existingStudentByPhoneNumber = studentRepository.findStudentByPhone(student.getStudentPhone());

        if (existingStudentByPhoneNumber.isPresent()){
            throw  new RuntimeException("Student with this phone number " + student.getStudentPhone() + " is present");
        }

        Optional<Student> existingStudentByEmail = studentRepository.findStudentByEmail(student.getStudentEmail());

        if (existingStudentByEmail.isPresent()){
            throw  new RuntimeException("Student with this  " + student.getStudentEmail() + " email is present");
        }

        Student registeredStudent = studentRepository.save(student);

        return ResponseEntity.ok(registeredStudent);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public ResponseEntity<Student> loginStudent(Student student){
        Optional<Student> existingStudentByEmail = studentRepository.findStudentByEmail(student.getStudentEmail());

        if (existingStudentByEmail.isEmpty()){
            throw  new RuntimeException("Student with this email " + student.getStudentEmail() + " is not registered]" +
                    "////");
        }
        Student loginStudent = studentRepository.save(student);

        return ResponseEntity.ok(loginStudent);
    }

}
