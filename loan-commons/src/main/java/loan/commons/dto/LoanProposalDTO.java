package loan.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class LoanProposalDTO {

    /*Attributs privés propres à la classe Loan Proposal*/

    private int proposalId;
    private ProjectDTO projectId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate proposalDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;
    private ApprovalStatus approvalStatus;
    private double loanAmount;
    private String description;
    private double interestRate;
    private int loanDurationMonth;
    private int idBank;

    public LoanProposalDTO() {
    }

    public LoanProposalDTO(ProjectDTO projectId, LocalDate proposalDate, LocalDate endDate, ApprovalStatus approvalStatus, double loanAmount, String description, double interestRate, int loanDurationMonth, int idBank) {
        this.projectId = projectId;
        this.proposalDate = proposalDate;
        this.endDate = endDate;
        this.approvalStatus = approvalStatus;
        this.loanAmount = loanAmount;
        this.description = description;
        this.interestRate = interestRate;
        this.loanDurationMonth = loanDurationMonth;
        this.idBank = idBank;
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public ProjectDTO getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectDTO projectId) {
        this.projectId = projectId;
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
                "projectId=" + projectId +
                ", proposalDate=" + proposalDate +
                ", endDate=" + endDate +
                ", approvalStatus=" + approvalStatus +
                ", loanAmount=" + loanAmount +
                ", description='" + description + '\'' +
                ", interestRate=" + interestRate +
                ", loanDurationMonth=" + loanDurationMonth +
                ", idBank=" + idBank +
                '}';
    }
}
