package fr.pantheonsorbonne.urf27.miage.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProject", nullable = false)
    private Integer idProject;

    @Column(name = "description", nullable = false)
    private String projectDescription;

    @Column(name = "estimatedStartDate", nullable = false)
    private LocalDate estimatedStartDate;

    @Column(name = "estimatedDeadline", nullable = false)
    private LocalDate estimatedDeadline;

    @Column(name = "demandedValue", nullable = false)
    private double demandedValue;

    public Project() {
    }

    public Project(String projectDescription, LocalDate estimatedStartDate, LocalDate estimatedDeadline, double demandedValue) {
        this.projectDescription = projectDescription;
        this.estimatedStartDate = estimatedStartDate;
        this.estimatedDeadline = estimatedDeadline;
        this.demandedValue = demandedValue;
        //Monetary.getDefaultAmountFactory()
        //.setCurrency(Monetary.getCurrency("EUR")).setNumber(demandedValue).create();;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public LocalDate getEstimatedStartDate() {
        return estimatedStartDate;
    }

    public void setEstimatedStartDate(LocalDate estimatedStartDate) {
        this.estimatedStartDate = estimatedStartDate;
    }

    public LocalDate getEstimatedDeadline() {
        return estimatedDeadline;
    }

    public void setEstimatedDeadline(LocalDate estimatedDeadline) {
        this.estimatedDeadline = estimatedDeadline;
    }

    public double getDemandedValue() {
        return demandedValue;
    }

    public void setDemandedValue(double demandedValue) {
        this.demandedValue = demandedValue;
    }
}
