package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import loan.commons.dto.ProjectDTO;
import org.apache.camel.Header;

public interface ProjectGateway {

    void sendProjectToBank(ProjectDTO projectDTO, int idBank);

    void updateStatusRejected(ProjectDTO project, @Header("idBank") int idBank) throws ProjectExceptions.ProjectPublicKeyNotFound;
}
