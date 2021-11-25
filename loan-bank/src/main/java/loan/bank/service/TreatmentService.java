package loan.bank.service;

import loan.bank.exception.entityNotFound;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

public interface TreatmentService {
    //Faudra vérifier le reçu
    LoanProposalDTO emmitLoanProposal(ProjectDTO projetdto) throws entityNotFound;

    //On a rien compris (voir schéma tableau)
    void receiveProject();

    void cancelationLoanProposal();

}
