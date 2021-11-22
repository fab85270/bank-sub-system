package fr.pantheonsorbonne.urf27.miage.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.time.Instant;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProject", nullable = false)
    private Integer idProject;

    @Column(name = "description", nullable = false)
    private String projectDescription;

    @Column(name = "estimatedStartDate", nullable = false)
    private Instant estimatedStartDate;

    @Column(name = "estimatedDeadline", nullable = false)
    private Instant estimatedDeadline;

    @Column(name = "demandedValue", nullable = false)
    private double demandedValue;

    public Project() {
    }

    public Project(Integer idProject, String projectDescription, Instant estimatedStartDate, Instant estimatedDeadline, double demandedValue) {
        this.idProject = idProject;
        this.projectDescription = projectDescription;
        this.estimatedStartDate = estimatedStartDate;
        this.estimatedDeadline = estimatedDeadline;
        this.demandedValue = demandedValue;
//                Monetary.getDefaultAmountFactory()
//            .setCurrency(Monetary.getCurrency("EUR")).setNumber(demandedValue).create();;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Instant getEstimatedStartDate() {
        return estimatedStartDate;
    }

    public void setEstimatedStartDate(Instant estimatedStartDate) {
        this.estimatedStartDate = estimatedStartDate;
    }

    public Instant getEstimatedDeadline() {
        return estimatedDeadline;
    }

    public void setEstimatedDeadline(Instant estimatedDeadline) {
        this.estimatedDeadline = estimatedDeadline;
    }

    public double getDemandedValue() {
        return demandedValue;
    }

    public void setDemandedValue(double demandedValue) {
        this.demandedValue = demandedValue;
    }
}
