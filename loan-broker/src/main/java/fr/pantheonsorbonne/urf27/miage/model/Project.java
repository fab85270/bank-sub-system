package fr.pantheonsorbonne.urf27.miage.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId", nullable = false)
    private Integer projectId;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "realEstateId")
    private RealEstate realEstateId;

    @Column(name = "description")
    private String projectDescription;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "borrowerId")
    private Borrower borrowerId;

    @Column(name = "proposalDate", nullable = false)
    private LocalDate proposalDate;

    @Column(name = "isDelivered")
    private Boolean isDelivered;

    @Column(name = "expirationDate", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "demandedValue", nullable = false)
    private double requiredValue;

    @Column(name = "durationMax", nullable = false)
    private int durationMax;

    public Project() {
    }

    public Project(String projectDescription, LocalDate proposalDate, LocalDate expirationDate, double requiredValue, int durationMax) {
        this.projectDescription = projectDescription;
        this.proposalDate = proposalDate;
        this.expirationDate = expirationDate;
        this.requiredValue = requiredValue;
        this.durationMax = durationMax;
        this.isDelivered = false;
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

    public LocalDate getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(LocalDate proposalDate) {
        this.proposalDate = proposalDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
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

    public Borrower getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Borrower borrowerId) {
        this.borrowerId = borrowerId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", \nrealEstateId=" + realEstateId +
                ", \nprojectDescription='" + projectDescription + '\'' +
                ", \nproposalDate=" + proposalDate +
                ", \nexpirationDate=" + expirationDate +
                ", \nrequiredValue=" + requiredValue +
                ", \ndurationMax=" + durationMax +
                '}';
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }
}
