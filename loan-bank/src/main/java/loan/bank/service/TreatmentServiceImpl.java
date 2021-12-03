package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.LoanProposalDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped

public class TreatmentServiceImpl implements TreatmentService {

    @Inject
    @ConfigProperty(name = "bank.interestRate15Years")
    double interestRate15Years;

    @Inject
    @ConfigProperty(name = "bank.interestRate20Years")
    double interestRate20Years;

    @Inject
    @ConfigProperty(name = "bank.interestRate25Years")
    double interestRate25Years;

    @ConfigProperty(name = "loan.bank.salaryCoefficient")
    double salaryCoefficient;

    @ConfigProperty(name = "loan.bank.minAge")
    int minAge;

    @ConfigProperty(name = "loan.bank.maxAge")
    int maxAge;

    @Override
    @Transactional
    public LoanProposalDTO setLastInfos(LoanProposalDTO proposal, LocalDate birthdate, double salary, double amount, double debtRatio) throws LoanProposalException.LoanProposalRefusedException {

        int age = LocalDate.now().getYear() - birthdate.getYear();
        if (isBetween(age, minAge, maxAge) && sufficientSalary(salary, amount) && debtRatio < 35) {

            int duration = proposal.getLoanDurationMonth();
            proposal.setInterestRate(getInterestRate(duration));
            if (duration > 25 * 12) {
                proposal.setLoanDurationMonth(300);
            }
        } else {
            throw new LoanProposalException.LoanProposalRefusedException();
        }
        return proposal;
    }

    public boolean sufficientSalary(double salary, double amount) {
        return salary >= salaryCoefficient * amount;
    }

    public double getInterestRate(int durationLoan) {

        if (durationLoan <= 15 * 12) {
            return interestRate15Years;
        } else if (durationLoan <= 20 * 12) {
            return interestRate20Years;
        } else {
            return interestRate25Years;
        }

    }

    public boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }


}
