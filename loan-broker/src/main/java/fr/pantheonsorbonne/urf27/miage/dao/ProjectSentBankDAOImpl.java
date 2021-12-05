package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.ApprovalStatus;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.ProjectSentBank;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

//Cette classe sert a voir quel projet ont été envoyé à quel bank
//Cela evite ainsi les doubles envois
@ApplicationScoped
public class ProjectSentBankDAOImpl implements ProjectSentBankDAO {

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;

    /* Creer une nouvelle entree dans la BDD */
    @Override
    @Transactional
    public void createSentBankProject(Project project, Bank bank) {
        ProjectSentBank p = new ProjectSentBank(project, bank);
        System.out.println(p);
        em.persist(p);
    }

    /*
    Verifie si un combo project/Bank est déjà présent dans la bdd
    Cela permet d'éviter le double envoie du même projet à la même bank
     */
    @Override
    @Transactional
    public boolean isSent(Project idProject, Bank idBank) {
        /* On regarde si le projet qu'on veut envoyer à la banque n'a pas déja été envoyé*/
        int nbProjetforBank = em.createQuery("Select p from ProjectSentBank p where p.bankId=:idBank AND p.projectId=:idProject")
                .setParameter("idBank", idBank)
                .setParameter("idProject", idProject)
                .getResultList()
                .size();

        //Borrower doesnt exists
        return nbProjetforBank != 0;
    }

    @Override
    @Transactional
    public void updateStatusRejected(int idProject, int idBank) {
        em.createQuery("UPDATE ProjectSentBank p SET p.approvalStatus=:status where p.bankId.bankId=:idBank AND p.projectId.projectId=:idProject")
                .setParameter("status", ApprovalStatus.REJECTED)
                .setParameter("idBank", idBank)
                .setParameter("idProject", idProject)
                .executeUpdate();
    }

}