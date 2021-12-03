package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class ProjectSentBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectSentBankId", nullable = false)
    private Integer projectSentBankId;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId")
    private Bank bankId;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    private Project projectId;

    /*Constructeurs*/
    public ProjectSentBank(Project projectId, Bank bankId) {
        this.bankId = bankId;
        this.projectId = projectId;
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
                "bankId=" + bankId +
                ", projectId=" + projectId +
                '}';
    }
}