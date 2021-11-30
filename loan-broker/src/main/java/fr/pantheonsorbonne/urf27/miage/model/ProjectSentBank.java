package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class ProjectSentBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposalId", nullable = false)
    private Integer proposalId;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId")
    private Bank bankId;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    private Project projectId;

    public ProjectSentBank(Project projectId, Bank bankId) {
        this.proposalId = proposalId;
        this.projectId = projectId;
    }
    public ProjectSentBank(){};

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
}
