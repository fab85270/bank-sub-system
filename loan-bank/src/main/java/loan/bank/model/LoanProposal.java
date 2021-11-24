package loan.bank.model;

import javax.persistence.*;
import java.time.Instant;

public class LoanProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposalId", nullable = false)
    private Integer proposalId;

    @ManyToOne(optional = true)
    @JoinColumn(name = "projectId", nullable = true)
    private Project projectId;

    @ManyToOne(optional = true)
    @JoinColumn(name = "bankId", nullable = true)
    private Bank bankId;

    @Column(name = "dateProposal", nullable = false)
    private Instant dateProposal;

    @Column(name = "endDate", nullable = false)
    private Instant endDate;

    @Column(name = "validationNumber", nullable = false)
    private long validationNumber;

    @Column(name = "isValid", nullable = false)
    private boolean isValid;

    @Column(name = "loanAmount", nullable = false)
    private double loanAmount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "interestRate", nullable = false)
    private double interestRate;

    @Column(name = "loanDurationMonth", nullable = false)
    private int loanDurationMonth;

    public LoanProposal(Bank bankId, Instant dateProposal, Instant endDate, long validationNumber, boolean isValid,
                        double loanAmount, String description, double interestRate, int loanDurationMonth) {
        this.bankId = bankId;
        this.dateProposal = dateProposal;
        this.endDate = endDate;
        this.validationNumber = validationNumber;
        this.isValid = isValid;
        this.loanAmount = loanAmount;
        this.description = description;
        this.interestRate = interestRate;
        this.loanDurationMonth = loanDurationMonth;
    }

    public LoanProposal() {
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public Instant getDateProposal() {
        return dateProposal;
    }

    public void setDateProposal(Instant dateProposal) {
        this.dateProposal = dateProposal;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public long getValidationNumber() {
        return validationNumber;
    }

    public void setValidationNumber(long validationNumber) {
        this.validationNumber = validationNumber;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
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
}
