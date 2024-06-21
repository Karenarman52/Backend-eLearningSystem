package eLearn.demo.module;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id",nullable = false, unique = true)
    private Long moduleId;
    @Column(name = "module_name",nullable = false)
    private String moduleName;
    @Column(name = "module_description",nullable = false)
    private String moduleDescription;
    @Column(name = "createdDate",nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @PrePersist
    protected void onRegistration(){
        createdDate = new Date();
    }
    public Module() {
    }

    public Module(Long moduleId, String moduleName, String moduleDescription, Date createdDate) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.createdDate = createdDate;
    }

    public Module(String moduleName, String moduleDescription, Date createdDate) {
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.createdDate = createdDate;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", moduleDescription='" + moduleDescription + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
