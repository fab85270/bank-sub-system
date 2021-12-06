package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.BorrowerDTO;
import loan.commons.dto.ProjectDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {


    @ConfigProperty(name = "loan.bank.salaryCoefficient")
    double salaryCoefficient;

    @ConfigProperty(name = "loan.bank.minAge")
    int minAge;

    @ConfigProperty(name = "loan.bank.maxAge")
    int maxAge;

    @ConfigProperty(name = "loan.bank.debtRatio")
    double debtRatio;

    @ConfigProperty(name = "loan.bank.maxDuration")
    int maxDuration;


    @Override
    public ProjectDTO isProjectEligible(ProjectDTO project) throws LoanProposalException.LoanProposalRefusedException {
        BorrowerDTO borrower = project.getBorrowerId();
        int age = LocalDate.now().getYear() - borrower.getBirthdate().getYear();

        boolean isEligible = (isBetween(age, minAge, maxAge)
                && project.getExpirationDate().isBefore(LocalDate.now())
                && sufficientSalary(borrower.getAnnualSalary(), project.getRequiredValue())
                && borrower.getDebtRatio() <= debtRatio
                && project.getDurationMax() > maxDuration);

        System.out.println("PROJECT ELIGIBLE === " + isEligible);
        if(!isEligible) throw new LoanProposalException.LoanProposalRefusedException(project.getProjectDescription());

        return project;
    }

    public boolean sufficientSalary(double salary, double amount) {
        return salary >= salaryCoefficient * amount;
    }

    public boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
