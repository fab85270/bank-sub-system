package loan.commons.dto;

import java.time.LocalDate;

public class ProjectDTO {

    private String projectDescription;
    private LocalDate projectProposalDate;
    private LocalDate projectExpirationDate;
    private double projectRequiredValue;
    private double projectDurationMax;
    private RealEstateDTO realEstate;
    private BorrowerDTO borrowerId;

    public ProjectDTO() {
    }

    public ProjectDTO(String projectDescription, LocalDate proposalDate, LocalDate projectExpirationDate,
                      double projectRequiredValue, double projectDurationMax, RealEstateDTO realEstate, BorrowerDTO borrowerId) {
        this.projectDescription = projectDescription;
        this.projectProposalDate = proposalDate;
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

    public LocalDate getProposalDate() {
        return projectProposalDate;
    }

    public void setProposalDate(LocalDate proposalDate) {
        this.projectProposalDate = proposalDate;
    }

    public LocalDate getProjectExpirationDate() {
        return projectExpirationDate;
    }

    public void setProjectExpirationDate(LocalDate projectExpirationDate) {
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
                ", proposalDate=" + projectProposalDate +
                ", projectExpirationDate=" + projectExpirationDate +
                ", projectRequiredValue=" + projectRequiredValue +
                ", projectDurationMax=" + projectDurationMax +
                ", realEstate=" + realEstate +
                ", borrowerDTO=" + borrowerId +
                '}';
    }
}
