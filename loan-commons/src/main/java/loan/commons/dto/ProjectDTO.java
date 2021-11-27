package loan.commons.dto;

import java.time.Instant;

public class ProjectDTO {

    private String projectDescription;
    private Instant proposalDate;
    private Instant projectExpirationDate;
    private double projectRequiredValue;
    private double projectDurationMax;
    private RealEstateDTO realEstate;
    private BorrowerDTO borrowerId;

    public ProjectDTO() {
    }

    public ProjectDTO(String projectDescription, Instant proposalDate, Instant projectExpirationDate,
                      double projectRequiredValue, double projectDurationMax, RealEstateDTO realEstate, BorrowerDTO borrowerId) {
        this.projectDescription = projectDescription;
        this.proposalDate = proposalDate;
        this.projectExpirationDate = projectExpirationDate;
        this.projectRequiredValue = projectRequiredValue;
        this.projectDurationMax = projectDurationMax;
        this.realEstate = realEstate;
        this.borrowerId = borrowerId;
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

    public Instant getProjectExpirationDate() {
        return projectExpirationDate;
    }

    public void setProjectExpirationDate(Instant projectExpirationDate) {
        this.projectExpirationDate = projectExpirationDate;
    }

    public double getProjectRequiredValue() {
        return projectRequiredValue;
    }

    public void setProjectRequiredValue(double projectRequiredValue) {
        this.projectRequiredValue = projectRequiredValue;
    }

    public double getProjectDurationMax() {
        return projectDurationMax;
    }

    public void setProjectDurationMax(double projectDurationMax) {
        this.projectDurationMax = projectDurationMax;
    }

    public RealEstateDTO getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstateDTO realEstate) {
        this.realEstate = realEstate;
    }

    public BorrowerDTO getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(BorrowerDTO borrowerId) {
        this.borrowerId = borrowerId;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectDescription='" + projectDescription + '\'' +
                ", proposalDate=" + proposalDate +
                ", projectExpirationDate=" + projectExpirationDate +
                ", projectRequiredValue=" + projectRequiredValue +
                ", projectDurationMax=" + projectDurationMax +
                ", realEstate=" + realEstate +
                ", borrowerDTO=" + borrowerId +
                '}';
    }
}
