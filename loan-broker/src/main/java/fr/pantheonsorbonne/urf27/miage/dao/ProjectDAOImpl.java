package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Project createProject(Project project) {

        em.persist(project);
        return project;
    }

    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException {
        try{
            return (Collection<Project>) em.createQuery("Select p from Project p").getResultList();
        }catch (NoResultException e){
            throw new EntityNotFoundException();
        }
    }

    /*
   Methode modifiant la valeur de isDelivered afin de le passer à true une fois l'envoie du projet client valide par
   le Brojer, ainsi il n'est plus affiche dans la liste de projet en cours
    */
    @Override
    @Transactional
    public void changeIsDelivered(int idProject) throws EntityNotFoundException{
        System.out.println("ID du projet est : "+ idProject);
        em.createQuery("UPDATE Project p SET p.isDelivered=true WHERE p.projectId=:idProject").setParameter("idProject",idProject).executeUpdate();
    }

    @Override
    public Project findProject(int idProject) throws EntityNotFoundException {
        try {
            Project p = (Project) em.createQuery("Select p from Project p where p.projectId=:idProject").setParameter("idProject", idProject).getSingleResult();
            return p;
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }

}