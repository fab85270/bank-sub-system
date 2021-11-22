package fr.pantheonsorbonne.ufr27.miage.dto;

import java.time.Instant;

public class Project {

    private Integer idProject;

    private String projectDescription;

    private Instant estimatedStartDate;

    private Instant estimatedDeadline;

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
