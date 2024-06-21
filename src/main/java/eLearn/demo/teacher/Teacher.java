package eLearn.demo.teacher;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false, unique = true)
    private Long teacherId;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(name = "teacher_email", nullable = false)
    private String teacherEmail;

    @Column(name = "teacher_phone", nullable = false)
    private String teacherPhone;

    @Column(name = "teacher_password", nullable = false)
    private String teacherPassword;


    @Column(name = "registedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registedDate;

    @PrePersist
    protected void onRegistration(){
        registedDate = new Date();
    }
    public Teacher(){

    }

    public Teacher(Long teacherId, String teacherName, String teacherEmail, String studentPhone, String teacherPassword, Date registedDate) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherPhone = studentPhone;
        this.teacherPassword = teacherPassword;
        this.registedDate = registedDate;
    }

    public Teacher(String teacherName, String teacherEmail, String studentPhone, String teacherPassword, Date registedDate) {
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherPhone = studentPhone;
        this.teacherPassword = teacherPassword;
        this.registedDate = registedDate;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone =teacherPhone;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public Date getRegistedDate() {
        return registedDate;
    }

    public void setRegistedDate(Date registedDate) {
        this.registedDate = registedDate;
    }


    @Override
    public String toString() {
        return "Teacherentity{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", studentPhone='" + teacherPhone + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", registedDate=" + registedDate +
                '}';
    }


}
