package eLearn.demo.teacher;

import eLearn.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("SELECT t FROM Teacher t WHERE t.teacherEmail = ?1")
    Optional<Teacher> findTeacherByEmail(String teacherEmail);
    @Query("SELECT t FROM Teacher t WHERE t.teacherPhone = ?1")
    Optional<Teacher> findTeacherByPhone(String teacherPhone);
}
