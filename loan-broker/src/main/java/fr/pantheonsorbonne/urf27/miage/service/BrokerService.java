package fr.pantheonsorbonne.urf27.miage.service;

//import fr.pantheonsorbonne.ufr27.miage.dto.*;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import java.util.Collection;

public interface BrokerService {

//    Broker createBroker(Broker broker);

    Collection<Bank> getBrokersBanks(int brokerId) throws EntityNotFoundException;

    Project createProject(RealEstate realEstate, String projectDescription, double requiredValue, int durationMax);

}
