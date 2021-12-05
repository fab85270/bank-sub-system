package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId", nullable = false)
    private Integer projectId;

    @Column(name = "publicKey")
    private String publicKey;

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

    @Column(name = "expirationDate", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "demandedValue", nullable = false)
    private double requiredValue;

    @Column(name = "durationMax", nullable = false)
    private int durationMax;

    public Project() {
    }

    public Project(String projectDescription, LocalDate proposalDate, LocalDate expirationDate, double requiredValue,
                   int durationMax) {
        this.projectDescription = projectDescription;
        this.proposalDate = proposalDate;
        this.expirationDate = expirationDate;
        this.requiredValue = requiredValue;
        this.durationMax = durationMax;
    }

    /*Getter & Setters */
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

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", publicKey=" + publicKey +
                ", realEstateId=" + realEstateId +
                ", projectDescription='" + projectDescription + '\'' +
                ", borrowerId=" + borrowerId +
                ", proposalDate=" + proposalDate +
                ", expirationDate=" + expirationDate +
                ", requiredValue=" + requiredValue +
                ", durationMax=" + durationMax +
                '}';
    }
}
