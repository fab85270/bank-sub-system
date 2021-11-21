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

    /* Lors de la création de la base de données, les Broker n'auront pas de banque et ni de borrowers associés*/
    public Broker(String name,String email){
        this.name = name;
        this.email = email;
        this.banks = new ArrayList<>();
        this.borrowers = new ArrayList<>();
    }

    public Collection<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Collection<Bank> banks) {
        this.banks = banks;
    }

    public Collection<Borrower> getBorrowers() {
        return borrowers;
    }
}
