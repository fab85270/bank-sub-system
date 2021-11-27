package fr.pantheonsorbonne.urf27.miage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.time.Instant;
import loan.commons.dto.ContratType;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProject")
    private Integer idProject;

    @Column(name = "description", nullable = false)
    private String projectDescription;

    @Column(name = "estimatedStartDate", nullable = false)
    private LocalDate estimatedStartDate;

    @Column(name = "estimatedDeadline", nullable = false)
    private LocalDate estimatedDeadline;

    @Column(name = "demandedValue", nullable = false)
    private double demandedValue;

    @Column(name = "isDelivered", nullable = false)
    private boolean isDelivered;

    @Column(name = "contratType", nullable = false)
    private ContratType contratType;


    public Project() {
    }

    public Project(String projectDescription, LocalDate estimatedStartDate, LocalDate estimatedDeadline, double demandedValue,ContratType contrat) {
        this.projectDescription = projectDescription;
        this.estimatedStartDate = estimatedStartDate;
        this.estimatedDeadline = estimatedDeadline;
        this.demandedValue = demandedValue;
        this.isDelivered = false;
        this.contratType = contrat;
        //Monetary.getDefaultAmountFactory()
        //setCurrency(Monetary.getCurrency("EUR")).setNumber(demandedValue).create();;
    }

    public Project(String descri){
        this.projectDescription = descri;
    }

    public Integer getIdProject() {
        return idProject;
    }

    @JsonProperty("Description")
    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @JsonProperty("StartDate")
    public LocalDate getEstimatedStartDate() {
        return estimatedStartDate;
    }

    public void setEstimatedStartDate(LocalDate estimatedStartDate) {
        this.estimatedStartDate = estimatedStartDate;
    }

    @JsonProperty("DeadLine")
    public LocalDate getEstimatedDeadline() {
        return estimatedDeadline;
    }

    public void setEstimatedDeadline(LocalDate estimatedDeadline) {
        this.estimatedDeadline = estimatedDeadline;
    }

    @JsonProperty("DemandedValue")
    public double getDemandedValue() {
        return demandedValue;
    }

    public void setDemandedValue(double demandedValue) {
        this.demandedValue = demandedValue;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public ContratType getContratType() {
        return contratType;
    }

    public void setContratType(ContratType contratType) {
        this.contratType = contratType;
    }
}
