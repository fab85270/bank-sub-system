package loan.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class ProjectDTO {

    private String publicKey;
    private RealEstateDTO realEstateId;
    private String projectDescription;
    private BorrowerDTO borrowerId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate proposalDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate expirationDate;
    private double requiredValue;
    private int durationMax;

    public ProjectDTO() {
    }

    public ProjectDTO(RealEstateDTO realEstateId, String projectDescription, BorrowerDTO borrowerId, LocalDate proposalDate, LocalDate expirationDate, double requiredValue, int durationMax) {
        this.realEstateId = realEstateId;
        this.projectDescription = projectDescription;
        this.borrowerId = borrowerId;
        this.proposalDate = proposalDate;
        this.expirationDate = expirationDate;
        this.requiredValue = requiredValue;
        this.durationMax = durationMax;
    }

    public RealEstateDTO getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(RealEstateDTO realEstateId) {
        this.realEstateId = realEstateId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public BorrowerDTO getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(BorrowerDTO borrowerId) {
        this.borrowerId = borrowerId;
    }

    public LocalDate getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(LocalDate proposalDate) {
        this.proposalDate = proposalDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getRequiredValue() {
        return requiredValue;
    }

    public void setRequiredValue(double requiredValue) {
        this.requiredValue = requiredValue;
    }

    public int getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(int durationMax) {
        this.durationMax = durationMax;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "publicKey='" + publicKey + '\'' +
                ", realEstateId=" + realEstateId +
                ", projectDescription='" + projectDescription + '\'' +
                ", borrowerId=" + borrowerId +
                ", proposalDate=" + proposalDate +
                ", expirationDate=" + expirationDate +
                ", requiredValue=" + requiredValue +
                ", durationMax=" + durationMax +
                '}';
    }
}
