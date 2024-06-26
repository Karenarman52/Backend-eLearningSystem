package eLearn.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.studentEmail = ?1")
    Optional<Student> findStudentByEmail(String studentEmail);
    @Query("SELECT s FROM Student s WHERE s.studentEmail = ?1")
    Student findStudentByEmailForLogin(String studentEmail);
    @Query("SELECT s FROM Student s WHERE s.studentPhone = ?1")
    Optional<Student> findStudentByPhone(String studentPhone);
    Student findBystudentEmail(String studentEmail);
}
