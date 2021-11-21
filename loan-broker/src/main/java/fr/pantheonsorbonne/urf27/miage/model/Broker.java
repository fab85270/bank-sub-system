package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Broker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBroker", nullable = false)
    private long idBroker;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "idBroker")
    private Collection<Bank> banks;

    @OneToMany(mappedBy = "idBroker")
    private Collection<Borrower> borrowers;

    public Broker() {
    }
}
