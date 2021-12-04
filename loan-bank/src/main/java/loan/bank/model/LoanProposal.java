package loan.bank.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class LoanProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposalId", nullable = false)
    private Integer proposalId;

    @ManyToOne(optional = true)
    @JoinColumn(name = "projectId", nullable = true)
    private Project projectId;

    @Column(name = "dateProposal", nullable = false)
    private LocalDate dateProposal;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @Column(name = "isAccepted", nullable = false)
    private boolean isAccepted;

    @Column(name = "loanAmount", nullable = false)
    private double loanAmount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "interestRate", nullable = false)
    private double interestRate;

    @Column(name = "loanDurationMonth", nullable = false)
    private int loanDurationMonth;

    @Column(name = "idBank", nullable = false)
    private int idBank;

    public LoanProposal() {
    }

    public LoanProposal(Integer proposalId, Project projectId, LocalDate dateProposal, LocalDate endDate,
                        long validationNumber, boolean isAccepted, double loanAmount, String description,
                        double interestRate, int loanDurationMonth, int idBank) {
        this.proposalId = proposalId;
        this.projectId = projectId;
        this.dateProposal = dateProposal;
        this.endDate = endDate;
        this.isAccepted = isAccepted;
        this.loanAmount = loanAmount;
        this.description = description;
        this.interestRate = interestRate;
        this.loanDurationMonth = loanDurationMonth;
        this.idBank = idBank;
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public LocalDate getDateProposal() {
        return dateProposal;
    }

    public void setDateProposal(LocalDate dateProposal) {
        this.dateProposal = dateProposal;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
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

}
