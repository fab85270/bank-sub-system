package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import loan.commons.dto.LoanProposalDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ConfirmationMsgGatewayImpl implements ConfirmationMsgGateway {

    @Inject
    CamelContext context;

    //Envoie le message de confirmation à la banque quand elle reçoit un loanProposal
    @Override
    public void sendConfirmationMessageToBank(LoanProposalDTO proposalDTO, int bankId) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBodyAndHeader("direct:proposalConfirm", proposalDTO,"idBank", bankId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
