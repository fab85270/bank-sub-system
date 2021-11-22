package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.persistence.*;
import java.util.Collection;

public class Broker {

    private Integer idBroker;

    private String firstName;

    private String lastName;

//    private Collection<Bank> banks;

    private Collection<Borrower> borrowers;

    public Broker() {
    }
}
