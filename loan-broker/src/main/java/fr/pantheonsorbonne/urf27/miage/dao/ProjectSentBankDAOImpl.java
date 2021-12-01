package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.ProjectSentBank;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProjectSentBankDAOImpl implements ProjectSentBankDAO{

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;


    @Override
    @Transactional
    public void createSentBankProject(Project project, Bank bank){

        /* On crée un nouveau n-uplet à cette classe */
        ProjectSentBank p = new ProjectSentBank();
        em.persist(p);

        /* On ajoute les attributs à cet n-uplet */

        em.createQuery("UPDATE ProjectSentBank p SET p.bankId=:bank, p.projectId=:project WHERE p.projectSentBankId=:id").setParameter("id",p.getProjectSentBankId()).setParameter("bank",bank).setParameter("project",project).executeUpdate();

    }

    @Override
    public boolean isSent(Project idProject, Bank idBank){
       /* On regarde si le projet qu'on veut envoyer à la banque n'a pas déja été envoyé*/



        int nbProjetforBank = em.createQuery("Select p from ProjectSentBank p where p.bankId=:idBank AND p.projectId=:idProject").setParameter("idBank", idBank).setParameter("idProject",idProject).getResultList().size();

        if (nbProjetforBank == 0) { //Borrower doesnt exists
            return false;
        }
        return true;
    }


}
