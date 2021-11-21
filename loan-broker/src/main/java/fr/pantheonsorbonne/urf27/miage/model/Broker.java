package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Broker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBroker", nullable = false)
    private long idBroker;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false,unique=true)
    private String email;

    @OneToMany(mappedBy = "idBroker")
    private Collection<Bank> banks;

    @OneToMany(mappedBy = "idBroker")
    private Collection<Borrower> borrowers;

    public Broker() {
    }

    public Broker(String name, String email, Collection<Bank> banks, Collection<Borrower> borrowers) {
        this.name = name;
        this.email = email;
        this.banks = banks;
        this.borrowers = borrowers;
    }
}
