package loan.bank.service;

import loan.bank.exception.ProjectException;
import loan.bank.exception.entityNotFound;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectSendByBrokerDTO;

public interface TreatmentService {
    //Faudra vérifier le reçu
    LoanProposalDTO emitLoanProposal(ProjectSendByBrokerDTO projetdto) throws entityNotFound.entityNotFoundException, ProjectException.ExpiredProjectException;

    //On a rien compris (voir schéma tableau)
    void receiveProject();

    void deleteLoanProposal();

}
