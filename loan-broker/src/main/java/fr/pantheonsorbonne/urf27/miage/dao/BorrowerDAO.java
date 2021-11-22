package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;
import fr.pantheonsorbonne.urf27.miage.model.Gender;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

public interface BorrowerDAO {

    /* Rechercher un borrower selon son mail */
    Borrower findMatchingBorrower(String email) throws EntityNotFoundException; //Mail étant un attribut unique propre à chaque Borrower.

    /*Obtenir la liste de tous les borrowers */
    List<Borrower> listBorrower();

    /*Supprimer tous les borrowers de la base de donnée*/
    void clearBorrowers();

    /*Supprimer un borrowers de la base de donnée selon son mail*/
    void deleteBorrower(String mail);

    /*Crée un nouveau borrower*/
    void createNewBorrower(String firstName, String lastName, Instant birthdate, Project idProject, Gender gender, String email, Broker idBroker);



}
