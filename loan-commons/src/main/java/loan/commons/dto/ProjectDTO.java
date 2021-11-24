package loan.commons.dto;

import java.time.Instant;

public class ProjectDTO {

    private int projectId;
    private int realEstateId;
    private String projectDescription;
    private Instant proposalDate;
    private Instant expirationDate;
    private double requiredValue;
    private double durationMax;

    public ProjectDTO() {
    }

    public int getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(int realEstateId) {
        this.realEstateId = realEstateId;
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

    public double getRequiredValue() {
        return requiredValue;
    }

    public void setRequiredValue(double requiredValue) {
        this.requiredValue = requiredValue;
    }

    public double getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(double durationMax) {
        this.durationMax = durationMax;
    }

}