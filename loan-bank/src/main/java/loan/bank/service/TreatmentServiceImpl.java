package loan.bank.service;

import loan.bank.dao.LoanProposalDAO;
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

    @Inject
    @ConfigProperty(name = "bank.name")
    String bankName;


    @Inject
    LoanProposalDAO loanProposalDAO;



    //mettre en variable d'environnement le debtratio, durationMax
    @Override
    @Transactional
    public LoanProposalDTO setLastInfos(LoanProposalDTO proposal, LocalDate birthdate, double salary, double amount, double debtRatioBorrower ) throws LoanProposalException.LoanProposalBankNotFoundException {


            int duration = proposal.getLoanDurationMonth();
            proposal.setInterestRate(getInterestRate(duration));
            if (duration > 25*12){
                proposal.setLoanDurationMonth(300);
            }


        return proposal;
    }


    public double getInterestRate(int durationLoan) throws LoanProposalException.LoanProposalBankNotFoundException {

        double rate = 0.0;
        if(durationLoan<= 15*12){
            rate = interestRate15Years;
        }else if(durationLoan<= 20*12){

            rate = interestRate20Years;
        }
        else{
            rate = interestRate25Years;
        }

        int size = loanProposalDAO.findMatchingPastLoanProposalWithBank(bankName).size();


        if(size==0){
            return rate;
        } else if(size==1){
            return rate-0.05;
        }
        else if(size<=3){
            return rate-0.1;
        }
        else {
            return rate-0.15;
        }
    }





}
