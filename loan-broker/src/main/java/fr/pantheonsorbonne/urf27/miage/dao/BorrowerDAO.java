package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.BorrowerException;
import fr.pantheonsorbonne.urf27.miage.model.*;

import java.time.LocalDate;
import java.util.List;

public interface BorrowerDAO {

    /* Rechercher un borrower selon son mail */
    Borrower findMatchingBorrower(String email) throws BorrowerException.BorrowerNotFound; //Mail étant un attribut unique propre à chaque Borrower.

    /*Obtenir la liste de tous les borrowers */
    List<Borrower> listBorrower();

    /*Supprimer tous les borrowers de la base de donnée*/
    void clearBorrowers();

    /*Supprimer un borrowers de la base de donnée selon son mail*/
    void deleteBorrower(String mail);

    /*Crée un nouveau borrower*/
    Borrower createNewBorrower(Address addressId, String email, String firstName, String lastName, Gender gender, LocalDate birthdate,
                               EmploymentContract employmentContract, double annualSalary, double firstDeposit, String phoneNumber,
                               double requiredInterest, int requiredDuration, double monthlyRefund, double debtRatio);

    Borrower createNewBorrower(Borrower borrower);

    Boolean mailUsed(String mail);

}