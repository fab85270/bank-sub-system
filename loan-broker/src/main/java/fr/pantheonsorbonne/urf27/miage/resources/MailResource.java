package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mail")
public class MailResource {

    @Inject
    ProjectServiceImpl projectService;

    /*
    Renvoie dans le header si le mail a deja ete utilise ou non
    */
    @Path("/{mailId}")
    @HEAD
    public Response mailUsed(@PathParam("mailId") String mail) throws EntityNotFoundException {

        if(projectService.mailUsed(mail)){
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