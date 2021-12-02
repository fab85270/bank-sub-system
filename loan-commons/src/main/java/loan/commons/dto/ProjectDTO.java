package loan.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class ProjectDTO {

    private String projectDescription;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate projectProposalDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate projectExpirationDate;
    private double projectRequiredValue;
    private int projectDurationMax;
    private RealEstateDTO realEstate;
    private BorrowerDTO borrowerDTO;

    public ProjectDTO() {
    }

    public ProjectDTO(String projectDescription, LocalDate projectProposalDate, LocalDate projectExpirationDate,
                      double projectRequiredValue, int projectDurationMax, RealEstateDTO realEstate, BorrowerDTO borrowerDTO) {
        this.projectDescription = projectDescription;
        this.projectProposalDate = projectProposalDate;
        this.projectExpirationDate = projectExpirationDate;
        this.projectRequiredValue = projectRequiredValue;
        this.projectDurationMax = projectDurationMax;
        this.realEstate = realEstate;
        this.borrowerDTO = borrowerDTO;
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

    public BorrowerDTO getBorrowerDTO() {
        return borrowerDTO;
    }

    public void setBorrowerDTO(BorrowerDTO borrowerDTO) {
        this.borrowerDTO = borrowerDTO;
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
                ", borrowerDTO=" + borrowerDTO +
                '}';
    }
}
