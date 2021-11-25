package loan.bank.service;

import loan.bank.dao.BorrowerDao;
import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;
import loan.bank.model.LoanProposal;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;

@ApplicationScoped

public class TreatmentServiceImpl implements TreatmentService{
    @Inject
    BorrowerDao borrowerDao;

    public static boolean isBetween(int x, int lower, int upper){
        return lower <= x && x<= upper;
    }

    public static boolean suficientSalary(double salary, double amount){
        if(salary >= 0.15*amount){
            return true;
        }
        return false;
    }


    @Override
    public LoanProposalDTO emitLoanProposal(ProjectDTO projetdto) throws entityNotFound.entityNotFoundException{
        Borrower borrower = null;
        borrower = borrowerDao.findMatchingBorrower(projetdto.getBorrowerId());

        /*Définition de l'âge du borrower selon sa date de naissance */

        int year = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
        int birthDate = borrower.getBirthdate().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
        int age = year - birthDate;
        double salary = borrower.getAnnualSalary();
        double amount = projetdto.getRequiredValue();


        if(isBetween(age, 18, 25) && suficientSalary(salary, amount) && borrower.getDebtRatio() < 35){

            //1er cas

        }else if(isBetween(age, 26, 35)&& suficientSalary(salary, amount) && borrower.getDebtRatio() < 35){

            //2eme cas

        }else if(isBetween(age, 35, 50)&& suficientSalary(salary, amount) && borrower.getDebtRatio() < 35){

            //3eme cas

        } else if(isBetween(age, 50, 70)&& suficientSalary(salary, amount) && borrower.getDebtRatio() < 35){

            //4eme cas

        } else {
            /*Refuser la demande du projet  => affichage de formulaire sortant à l'écran ? A voir comment faire si c possible..*/
           // System.out.println("Demande refusée, vous n'êtes pas éligible");

        }


        //realEstae = realEstatedao.findatchEstate(projetdto.getRealEstateId());

        /*
        Verifier les infos du borrower
            - Son salaire annuel doit être au moins égal à 15 % de son emprunt.
            - Son taux d'endettement => il doit être maximal de 35%

            Créer différents paniers pour les taux d'emprunts générés.

            - tranche 18-25
                Si revenus sont => appartient au groupe  B
                Si revenus sont => appartient au groupe  A
                Si revenus sont => appartient au groupe  S

            - tranche 26-35

                Si revenus sont => appartient au groupe  B
                Si revenus sont => appartient au groupe  A
                Si revenus sont => appartient au groupe  S

            - tranche 35 - 50

                Si revenus sont => appartient au groupe  B
                Si revenus sont => appartient au groupe  A
                Si revenus sont => appartient au groupe  S

            - tranche 50 - 65

                Si revenus sont => appartient au groupe  B
                Si revenus sont => appartient au groupe  A
                Si revenus sont => appartient au groupe  S



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
