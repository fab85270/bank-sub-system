package loan.commons.dto;

import java.time.LocalDate;

public class LoanProposal {

    /*Attributs privés propres à la classe Loan Proposal*/

    private LocalDate dateSimulation;

    private double interestRate; // En %

    private int loanDuration; //Exprimé en mois.

    private double monthlyRefund; //Montant du remboursement de chaque mois.

    //Il existe aussi le taux endettement (généralement 33% en france).
    private double debtRate; // En %

    private LocalDate dateEnd;

    //Une LoanSimulation concerne un un seul employé de banque.
    private Officer officer;

    /*Constructeurs de la classe LoanProposal */
    public LoanProposal(){}

    public LoanProposal(LocalDate dateSimulation, double interestRate, int loanDuration, double monthlyRefund, double debtRate, LocalDate dateEnd, Officer officer) {
        this.dateSimulation = dateSimulation;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.monthlyRefund = monthlyRefund;
        this.debtRate = debtRate;
        this.dateEnd = dateEnd;
        this.officer = officer;
    }

    /*Getter & Setter*/
    public LocalDate getDateSimulation() {
        return dateSimulation;
    }

    public void setDateSimulation(LocalDate dateSimulation) {
        this.dateSimulation = dateSimulation;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public double getMonthlyRefund() {
        return monthlyRefund;
    }

    public void setMonthlyRefund(double monthlyRefund) {
        this.monthlyRefund = monthlyRefund;
    }

    public double getDebtRate() {
        return debtRate;
    }

    public void setDebtRate(double debtRate) {
        this.debtRate = debtRate;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }
}
