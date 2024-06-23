package eLearn.demo.topic;

import eLearn.demo.subtopic.Subtopic;
import eLearn.demo.module.Module;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id",nullable = false,unique = true)
    private Long topicId;



    @Column(name = "topic_name",nullable = false)
    private String topicName;

    @Column(name = "topic_description",nullable = false)
    private String topicDescription;
    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false)
    private Module module;

    @OneToMany(mappedBy = "topic")
    private List<Subtopic> contenttopics;

    @Column(name = "registedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registedDate;
    @PrePersist
    protected void onRegistration(){
        registedDate = new Date();
    }
    public Topic() {
    }

    public Topic(Long topicId, String topicName, String topicDescription, Module module, Date registedDate) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.module = module;
        this.registedDate = registedDate;
    }

    public Topic(String topicName, String topicDescription, Module module, Date registedDate) {
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.module = module;
        this.registedDate = registedDate;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Date getRegistedDate() {
        return registedDate;
    }

    public void setRegistedDate(Date registedDate) {
        this.registedDate = registedDate;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", topicDescription='" + topicDescription + '\'' +
                ", module=" + module +
                ", registedDate=" + registedDate +
                '}';
    }
}
