package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import loan.commons.dto.ProjectDTO;

public interface ProjectGateway {

    void sendProjectToBank(ProjectDTO projectDTO);

}
