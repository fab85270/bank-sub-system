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

    @Column(name = "idBank", nullable = false)
    private int idBank;

    @Column(name = "nameBank", nullable = false)
    private String nameBank;

    public LoanProposal() {
    }

    public LoanProposal(Integer proposalId, Project projectId, LocalDate dateProposal, LocalDate endDate, long validationNumber, boolean isValid, double loanAmount, String description, double interestRate, int loanDurationMonth, int idBank, String nameBank) {
        this.proposalId = proposalId;
        this.projectId = projectId;
        this.dateProposal = dateProposal;
        this.endDate = endDate;
        this.validationNumber = validationNumber;
        this.isValid = isValid;
        this.loanAmount = loanAmount;
        this.description = description;
        this.interestRate = interestRate;
        this.loanDurationMonth = loanDurationMonth;
        this.idBank = idBank;
        this.nameBank = nameBank;
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

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }
}
