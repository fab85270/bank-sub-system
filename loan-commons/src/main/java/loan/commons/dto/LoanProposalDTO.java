package loan.commons.dto;

import java.time.LocalDate;

public class LoanProposalDTO {

    /*Attributs privés propres à la classe Loan Proposal*/

    private ProjectDTO projectDTO;
    private LocalDate proposalDate;
    private LocalDate endDate;
    private ApprovalStatus approvalStatus;
    private double loanAmount;
    private String description;
    private double interestRate;
    private int loanDurationMonth;
    private int idBank;

    public LoanProposalDTO() {
    }

    public LoanProposalDTO(ProjectDTO projectDTO, LocalDate proposalDate, LocalDate endDate, ApprovalStatus approvalStatus, double loanAmount, String description, double interestRate, int loanDurationMonth, int idBank) {
        this.projectDTO = projectDTO;
        this.proposalDate = proposalDate;
        this.endDate = endDate;
        this.approvalStatus = approvalStatus;
        this.loanAmount = loanAmount;
        this.description = description;
        this.interestRate = interestRate;
        this.loanDurationMonth = loanDurationMonth;
        this.idBank = idBank;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
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

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    @Override
    public String toString() {
        return "LoanProposalDTO{" +
                "projectDTO=" + projectDTO +
                ", proposalDate=" + proposalDate +
                ", endDate=" + endDate +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", loanAmount=" + loanAmount +
                ", description='" + description + '\'' +
                ", interestRate=" + interestRate +
                ", loanDurationMonth=" + loanDurationMonth +
                ", idBank=" + idBank +
                '}';
    }
}
