package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.BorrowerNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.Gender;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

public interface BorrowerDAO {

    /* Rechercher un borrower selon son mail */
    Borrower findMatchingBorrower(String email) throws BorrowerNotFoundException; //Mail étant un attribut unique propre à chaque Borrower.

    /* Créer un nouveau Borrower dans la table des borrowers */
  //  @Transactional
    //Borrower createNewBorrower(String name, Instant birthdate, Project project, Gender gender,String mail,Broker broker);

    /* Création de la table contenant l'ensemble des borrowers à l'initialisation du projet */
    @Transactional
    void createBaseBorrower();

    /*Obtenir la liste de tous les borrowers */

    @Transactional
    List<Borrower> listBorrower();

}
