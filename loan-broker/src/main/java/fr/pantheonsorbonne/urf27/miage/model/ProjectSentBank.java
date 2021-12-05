package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class ProjectSentBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectSentBankId", nullable = false)
    private Integer projectSentBankId;

    @ManyToOne()
    @JoinColumn(name = "bankId")
    private Bank bankId;

    @ManyToOne()
    @JoinColumn(name = "projectId")
    private Project projectId;

    @Column(name="approvalStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    /*Constructeurs*/
    public ProjectSentBank(Project projectId, Bank bankId) {
        this.bankId = bankId;
        this.projectId = projectId;
        approvalStatus = ApprovalStatus.PENDING;
    }
    public ProjectSentBank(){};

    /*Getter & Setters */
    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectSentBankId() {
        return projectSentBankId;
    }

    @Override
    public String toString() {
        return "ProjectSentBank{" +
                "projectSentBankId=" + projectSentBankId +
                ", bankId=" + bankId +
                ", projectId=" + projectId +
                ", approvalStatus=" + approvalStatus +
                '}';
    }
}