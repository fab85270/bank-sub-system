package loan.commons.dto;

import java.time.Instant;

public class LoanProposalDTO {

    /*Attributs privés propres à la classe Loan Proposal*/


    ProjectSendByBrokerDTO projectDTO;
    BrokerDTO brokerDTO;
    Instant proposalDate;
    Instant endDate;
    Boolean isValid;
    double loanAmount;
    String description;
    double interestRate;
    int loanDurationMonth;

    public LoanProposalDTO() {
    }



    public Instant getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(Instant proposalDate) {
        this.proposalDate = proposalDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanDurationMonth() {
        return loanDurationMonth;
    }

    public void setLoanDurationMonth(int loanDurationMonth) {
        this.loanDurationMonth = loanDurationMonth;
    }


    public ProjectSendByBrokerDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectSendByBrokerDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public void setBrokerDTO(BrokerDTO brokerDTO) {
        this.brokerDTO = brokerDTO;
    }
}
