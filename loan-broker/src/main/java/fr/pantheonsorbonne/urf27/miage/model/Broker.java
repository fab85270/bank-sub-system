package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Broker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBroker", nullable = false)
    private Integer idBroker;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false,unique=true)
    private String email;

    @OneToMany(mappedBy = "idBroker")
    private Collection<Bank> banks;

    @OneToMany(mappedBy = "idBroker")
    private Collection<Borrower> borrowers;

    public Broker() {
    }

    public Integer getIdBroker() {
        return idBroker;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setBorrowers(Collection<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public Broker(String firstName, String lastName, String email, Collection<Bank> banks, Collection<Borrower> borrowers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.banks = banks;
        this.borrowers = borrowers;
    }

    //Lors de la création de la base de données, les Broker n'auront pas de banque et ni de borrowers associés*/
    public Broker(String firstName, String lastName,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.banks = new ArrayList<>();
        this.borrowers = new ArrayList<>();
    }
}
