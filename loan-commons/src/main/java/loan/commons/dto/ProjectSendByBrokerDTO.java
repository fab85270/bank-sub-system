package loan.commons.dto;

import java.time.Instant;

public class ProjectSendByBrokerDTO {

    String projectDescription;
    double requiredValue;//Somme demandée par l'utilisateur.
    int durationMax; // Durée de remboursement désirée par le Borrower en mois

    Instant proposalDate;
    Instant expirationDate;



    RealEstateDTO realEstateId;
    BorrowerDTO borrowerId;
    BrokerDTO brokerId;






    public ProjectSendByBrokerDTO() {
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

    public int getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(int durationMax) {
        this.durationMax = durationMax;
    }

    public RealEstateDTO getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(RealEstateDTO realEstateId) {
        this.realEstateId = realEstateId;
    }

    public BorrowerDTO getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(BorrowerDTO borrowerId) {
        this.borrowerId = borrowerId;
    }

    public BrokerDTO getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(BrokerDTO brokerId) {
        this.brokerId = brokerId;
    }
}
