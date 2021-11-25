package loan.bank.service;

import loan.bank.dao.BorrowerDao;
import loan.bank.exception.ProjectException;
import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;
import loan.bank.model.LoanProposal;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectSendByBrokerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Instant;
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
    public static double getInterestRate(double salary, double amount, String classeAge){

        if (classeAge == "jeune"){
            if(salary >= 0.15*amount && salary >= 0.15*amount){
                double interestRate = 00;
            }
        }
        return interestRate;


    }

    public static int getDurationLoan(int durationWanted){
        /* Définition de */
        /**/


    }





    @Override
    public LoanProposalDTO emitLoanProposal(ProjectSendByBrokerDTO projectdto) throws entityNotFound.entityNotFoundException, ProjectException.ExpiredProjectException {


        //Verify if project is expired
        if (projectdto.getExpirationDate().isBefore(Instant.now())) {
            throw new ProjectException.ExpiredProjectException(projectdto.getProjectId());
        }

        Borrower borrower = null;
        borrower = borrowerDao.findMatchingBorrower(projectdto.getBorrowerId());

        /*Définition de l'âge du borrower selon sa date de naissance */

        int year = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
        int birthDate = borrower.getBirthdate().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
        int age = year - birthDate;
        double salary = borrower.getAnnualSalary();
        double amount = projectdto.getRequiredValue();


        if(isBetween(age, 18, 25) && suficientSalary(salary, amount) && borrower.getDebtRatio() < 35){


            LoanProposal proposal = new LoanProposal(Instant.now(), projectdto.getExpirationDate(),0,  false, amount, projectdto.getProjectDescription(), getInterestRate(salary, amount), getDurationLoan(projectdto.getDurationMax()));

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
