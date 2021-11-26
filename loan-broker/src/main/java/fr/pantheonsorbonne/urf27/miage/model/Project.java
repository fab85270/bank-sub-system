package fr.pantheonsorbonne.urf27.miage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.time.Instant;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProject")
    private Integer idProject;

    @Column(name = "description", nullable = false)
    private String projectDescription;

    @Column(name = "estimatedStartDate", nullable = false)
    private Instant estimatedStartDate;

    @Column(name = "estimatedDeadline", nullable = false)
    private Instant estimatedDeadline;

    @Column(name = "demandedValue", nullable = false)
    private double demandedValue;

    @Column(name = "isDelivered", nullable = false)
    private boolean isDelivered;

    public Project() {
    }

    public Project(String projectDescription, Instant estimatedStartDate, Instant estimatedDeadline, double demandedValue) {
        this.projectDescription = projectDescription;
        this.estimatedStartDate = estimatedStartDate;
        this.estimatedDeadline = estimatedDeadline;
        this.demandedValue = demandedValue;
        this.isDelivered = false;
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
    public Instant getEstimatedStartDate() {
        return estimatedStartDate;
    }

    public void setEstimatedStartDate(Instant estimatedStartDate) {
        this.estimatedStartDate = estimatedStartDate;
    }

    @JsonProperty("DeadLine")
    public Instant getEstimatedDeadline() {
        return estimatedDeadline;
    }

    public void setEstimatedDeadline(Instant estimatedDeadline) {
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
}
