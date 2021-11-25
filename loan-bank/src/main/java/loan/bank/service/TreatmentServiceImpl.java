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

        //realEstae = realEstatedao.findatchEstate(projetdto.getRealEstateId());

        /*
        Verifier les infos du borrower
            Son salaire annuel doit être égal à 15 % de son emprunt.
            Sa date de naissance
            Son taux d'endettement => il doit être maximal de 35%



            Durée maximum rentabilité => 25 ans

        //On va sauvegarder la proposition
        //MAPPER Pour passer d'un DTO à un entity


         */

        return null;
    }


    //TODO
    @Override
    public void receiveProject(){}

    @Override
    public void deleteLoanProposal(){}
}
