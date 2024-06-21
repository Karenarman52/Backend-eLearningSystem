package eLearn.demo.teacher;

import eLearn.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Teacherservice {
    private TeacherRepository teacherRepository;
    @Autowired
    public Teacherservice(TeacherRepository teacherRepository){
        this.teacherRepository= teacherRepository;
    }
    public ResponseEntity<Teacher> registerTeacher(Teacher teacher){
        Optional<Teacher> existingTeacherByPhoneNumber = teacherRepository.findTeacherByPhone(teacher.getTeacherPhone());

        if (existingTeacherByPhoneNumber.isPresent()){
            throw  new RuntimeException(" with Teacher this phone number " + teacher.getTeacherPhone() + " is present");
        }

        Optional<Teacher> existingTeacherByEmail = teacherRepository.findTeacherByEmail(teacher.getTeacherEmail());

        if (existingTeacherByEmail.isPresent()){
            throw  new RuntimeException("Student with this  " + teacher.getTeacherEmail() + " email is present");
        }

        Teacher registeredTeacher = teacherRepository.save(teacher);

        return ResponseEntity.ok(registeredTeacher);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public ResponseEntity<Teacher> loginStudent(Teacher teacher){
        Optional<Teacher> existingTeacherByEmail = teacherRepository.findTeacherByEmail(teacher.getTeacherEmail());

        if (existingTeacherByEmail.isEmpty()){
            throw  new RuntimeException("Student with this email " + teacher.getTeacherEmail() + " is not registered]" +
                    "////");
        }
        Teacher loginStudent = teacherRepository.save(teacher);

        return ResponseEntity.ok(loginStudent);
    }
}
