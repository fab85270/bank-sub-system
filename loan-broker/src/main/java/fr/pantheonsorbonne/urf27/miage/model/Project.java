package fr.pantheonsorbonne.urf27.miage.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.time.Instant;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId", nullable = false)
    private Integer projectId;

    @OneToOne(optional = true)
    @JoinColumn(name = "realEstateId", nullable = false)
    private RealEstate realEstateId;

    @Column(name = "description")
    private String projectDescription;

    @Column(name = "proposalDate", nullable = false)
    private Instant proposalDate;

    @Column(name = "expirationDate", nullable = false)
    private Instant expirationDate;

    @Column(name = "demandedValue", nullable = false)
    private double requiredValue;

    @Column(name = "durationMax", nullable = false)
    private int durationMax;

    public Project() {
    }

    public Project(String projectDescription, Instant proposalDate, Instant expirationDate, double requiredValue, int durationMax) {
        this.projectDescription = projectDescription;
        this.proposalDate = proposalDate;
        this.expirationDate = expirationDate;
        this.requiredValue = requiredValue;
        this.durationMax = durationMax;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Instant getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(Instant proposalDate) {
        this.proposalDate = proposalDate;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getrequiredValue() {
        return requiredValue;
    }

    public void setrequiredValue(double requiredValue) {
        this.requiredValue = requiredValue;
    }

    public int getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(int durationMax) {
        this.durationMax = durationMax;
    }

    public RealEstate getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(RealEstate realEstateId) {
        this.realEstateId = realEstateId;
    }

    public double getRequiredValue() {
        return requiredValue;
    }

    public void setRequiredValue(double requiredValue) {
        this.requiredValue = requiredValue;
    }
}
