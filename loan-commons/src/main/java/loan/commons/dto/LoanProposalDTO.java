package loan.commons.dto;

import java.time.LocalDate;

public class LoanProposalDTO {

    /*Attributs privés propres à la classe Loan Proposal*/

    private ProjectDTO projectDTO;
    private LocalDate dateProposal;
    private LocalDate endDate;
    private boolean isAccepted;
    private double loanAmount;
    private String description;
    private double interestRate;
    private int loanDurationMonth;
    private int idBank;

    public LoanProposalDTO() {
    }

    public LoanProposalDTO(ProjectDTO projectDTO, LocalDate dateProposal, LocalDate endDate, boolean isAccepted,
                           double loanAmount, String description, double interestRate, int loanDurationMonth, int idBank) {
        this.projectDTO = projectDTO;
        this.dateProposal = dateProposal;
        this.endDate = endDate;
        this.isAccepted = isAccepted;
        this.loanAmount = loanAmount;
        this.description = description;
        this.interestRate = interestRate;
        this.loanDurationMonth = loanDurationMonth;
        this.idBank = idBank;
    }

    public LocalDate getDateProposal() {
        return dateProposal;
    }

    public void setDateProposal(LocalDate dateProposal) {
        this.dateProposal = dateProposal;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public LocalDate getProposalDate() {
        return dateProposal;
    }

    public void setProposalDate(LocalDate dateProposal) {
        this.dateProposal = dateProposal;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
