package fr.pantheonsorbonne.ufr27.miage;

import javax.inject.Inject;

import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;

import fr.pantheonsorbonne.urf27.miage.service.BankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BankServiceTest {

    @Inject
    BankService service;


    @Test
    public void testGreetingService() throws BankExceptions.BankAlreadyExists, BankExceptions.BanksNotFoundId, BankExceptions.BanksNotFound {


        Assertions.assertEquals("BNP", service.findBank(1).getBankName());
        Assertions.assertEquals("LCL", service.findBank(2).getBankName());

        Assertions.assertEquals(2, service.getBanks().size());

    }
}