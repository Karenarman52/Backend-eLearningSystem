package eLearn.demo.content;

import eLearn.demo.subtopic.Subtopic;
import eLearn.demo.topic.Topic;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id",nullable = false,unique = true)
    private Long contentId;

    @Column(name = "content_name",nullable = false)
    private String contentName;

    @Column(name = "content_description",nullable = true)
    private String ContentName;

    @ManyToOne
    @JoinColumn(name = "subtopic_id",referencedColumnName = "subtopic_id",nullable = false)
    private Subtopic subtopic;

    @Column(name="registeredDate",nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registeredDate;

    @PrePersist
    protected void onRegistration(){
        registeredDate = new Date();
    }

    public Content() {
    }

    public Content(Long contentId, String contentName, String contentName1, Subtopic subtopic, Date registeredDate) {
        this.contentId = contentId;
        this.contentName = contentName;
        ContentName = contentName1;
        this.subtopic = subtopic;
        this.registeredDate = registeredDate;
    }

    public Content(String contentName, String contentName1, Subtopic subtopic, Date registeredDate) {
        this.contentName = contentName;
        ContentName = contentName1;
        this.subtopic = subtopic;
        this.registeredDate = registeredDate;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public Subtopic getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(Subtopic subtopic) {
        this.subtopic = subtopic;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", contentName='" + contentName + '\'' +
                ", ContentName='" + ContentName + '\'' +
                ", subtopic=" + subtopic +
                ", registeredDate=" + registeredDate +
                '}';
    }
}
