package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.ProjectGateway;
import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.ProjectSentBank;
import fr.pantheonsorbonne.urf27.miage.service.*;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectSentBankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAO;
import loan.commons.dto.ProjectDTO;
import loan.commons.dto.SelectProjetBankDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/broker")
public class BrokerResource {

    @Inject
    ProjectSentBankServiceImpl projectSentBankService;

    @Inject
    BankService bankService;

    @Inject
    BrokerServiceImpl brokerService;

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    ProjectGateway projectGateway;

    @Inject
    LoanProposalService loanProposalService;

}