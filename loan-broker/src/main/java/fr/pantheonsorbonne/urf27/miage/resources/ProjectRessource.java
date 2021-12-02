package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BankService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectSentBankServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/project")
public class ProjectRessource {

    @Inject
    ProjectSentBankServiceImpl projectSentBankService;

    @Inject
    BankService bankService;

    @Inject
    ProjectServiceImpl projectService;

    @Path("/{bank}/{projet}")
    @HEAD
    public Response isSent(@PathParam("bank") int idBank, @PathParam("projet") int idProject) throws EntityNotFoundException {

        //Recherche de la bank
        Bank b = bankService.findBank(idBank);
        //Recherche du projet
        Project p = projectService.findProject(idProject);

        if(projectSentBankService.isSent(b,p)){
            Response r = Response
                    .status(Response.Status.FOUND)
                    .build();
            return r;
        }else{
            Response r = Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
            return r;
        }
    }
}
