package loan.commons.dto;

import java.time.LocalDate;

public class LoanProposalDTO {

    /*Attributs privés propres à la classe Loan Proposal*/


    ProjectDTO projectDTO;
    LocalDate proposalDate;
    LocalDate endDate;
    Boolean isValid;
    double loanAmount;
    String description;
    double interestRate;
    int loanDurationMonth;
    String nameBank;

    public LoanProposalDTO() {
    }


    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public LocalDate getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(LocalDate proposalDate) {
        this.proposalDate = proposalDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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


    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

}
