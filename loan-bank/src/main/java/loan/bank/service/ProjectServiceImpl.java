package loan.bank.service;

import loan.commons.dto.BorrowerDTO;
import loan.commons.dto.ProjectDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {


    @ConfigProperty(name = "loan.bank.salaryCoefficient")
    double salaryCoefficient;

    @ConfigProperty(name = "loan.bank.minAge")
    int minAge;

    @ConfigProperty(name = "loan.bank.maxAge")
    int maxAge;

    @Inject
    @ConfigProperty(name = "loan.bank.debtRatio")
    double debtRatio;

    @Inject
    @ConfigProperty(name = "loan.bank.maxDuration")
    int maxDuration;


    @Override
    public boolean isProjectEligible(ProjectDTO project) {
        System.out.println(project);
        BorrowerDTO borrower = project.getBorrowerId();
        int age = LocalDate.now().getYear() - borrower.getBirthdate().getYear();

        return (isBetween(age, minAge, maxAge)
                && project.getProjectExpirationDate().isBefore(LocalDate.now())
                && sufficientSalary(borrower.getAnnualSalary(), project.getProjectRequiredValue())
                && borrower.getDebtRatio() <= debtRatio
                && project.getProjectDurationMax() > maxDuration);
    }

    public boolean sufficientSalary(double salary, double amount) {
        return salary >= salaryCoefficient * amount;
    }

    public boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
