package fr.pantheonsorbonne.urf27.miage.dao;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class BorrowerDAOImpl implements BorrowerDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

}
