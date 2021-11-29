package loan.commons.dto;

import java.time.LocalDate;

public class ProjectDTO {

    private String projectDescription;
    private LocalDate projectProposalDate;
    private LocalDate projectExpirationDate;
    private double projectRequiredValue;
    private int projectDurationMax;
    private RealEstateDTO realEstate;
    private BorrowerDTO borrowerId;


    public ProjectDTO() {
    }

    public ProjectDTO(String projectDescription, LocalDate projectProposalDate, LocalDate projectExpirationDate, double projectRequiredValue, int projectDurationMax, RealEstateDTO realEstate, BorrowerDTO borrowerId) {
        this.projectDescription = projectDescription;
        this.projectProposalDate = projectProposalDate;
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

    public LocalDate getProjectProposalDate() {
        return projectProposalDate;
    }

    public void setProjectProposalDate(LocalDate projectProposalDate) {
        this.projectProposalDate = projectProposalDate;
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

    public int getProjectDurationMax() {
        return projectDurationMax;
    }

    public void setProjectDurationMax(int projectDurationMax) {
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
}
