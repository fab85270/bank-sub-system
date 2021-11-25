package loan.bank.service;

import loan.bank.dao.BorrowerDao;
import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
@ApplicationScoped

public class TreatmentServiceImpl implements TreatmentService{
    @Inject
    BorrowerDao borrowerDao;
    @Override

    public LoanProposalDTO emitLoanProposal(ProjectDTO projetdto) throws entityNotFound.entityNotFoundException{
        Borrower borrower = null;
        borrower = borrowerDao.findMatchingBorrower(projetdto.getBorrowerId());


        /*
        Verifier les infos du borrower
            Son salaire
            Sa date de naissance
            Son taux d'endetement => Corresponds au crédit déjà possédé
         */

        return null;
    }


    //TODO
    @Override
    public void receiveProject(){}

    @Override
    public void deleteLoanProposal(){}
}
