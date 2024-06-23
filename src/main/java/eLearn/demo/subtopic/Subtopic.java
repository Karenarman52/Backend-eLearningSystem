package eLearn.demo.subtopic;

import eLearn.demo.topic.Topic;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "subtopic")
public class Subtopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtopic_id",nullable = false,unique = true)
    private Long subtopicId;

    @Column(name = "subtopic_name",nullable = false)
    private String subtopicName;
    @Column(name="filePath",nullable = true)
    private String filePath;


    @Column(name = "subtopic_description",nullable = true)
    private String subtopicDescription;

    @ManyToOne
    @JoinColumn(name = "topic_id",referencedColumnName = "topic_id",nullable = false)
    private Topic topic;

    @Column(name="registeredDate",nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registeredDate;

    @PrePersist
    protected void onRegistration(){
        registeredDate = new Date();
    }

    public Subtopic() {
    }

    public Subtopic(Long subtopicId, String url, String subtopicName, String filePath, String subtopicDescription, Topic topic, Date registeredDate) {
        this.subtopicId = subtopicId;
        this.subtopicName = subtopicName;
        this.filePath = filePath;
        this.subtopicDescription = subtopicDescription;
        this.topic = topic;
        this.registeredDate = registeredDate;
    }

    public Subtopic(String url, String subtopicName, String filePath, String subtopicDescription, Topic topic, Date registeredDate) {
        this.subtopicName = subtopicName;
        this.filePath = filePath;
        this.subtopicDescription = subtopicDescription;
        this.topic = topic;
        this.registeredDate = registeredDate;
    }

    public Long getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(Long subtopicId) {
        this.subtopicId = subtopicId;
    }



    public String getSubtopicName() {
        return subtopicName;
    }

    public void setSubtopicName(String subtopicName) {
        this.subtopicName = subtopicName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSubtopicDescription() {
        return subtopicDescription;
    }

    public void setSubtopicDescription(String subtopicDescription) {
        this.subtopicDescription = subtopicDescription;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "Contenttopic{" +
                "subtopicId=" + subtopicId +
                ", subtopicName='" + subtopicName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", subtopicDescription='" + subtopicDescription + '\'' +
                ", topic=" + topic +
                ", registeredDate=" + registeredDate +
                '}';
    }
}

