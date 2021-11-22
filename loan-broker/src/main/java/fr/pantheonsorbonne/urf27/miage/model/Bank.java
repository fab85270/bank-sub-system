package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private long idBank;

    /*Deux banques ne peuvent avoir le même nom */
    @Column(name = "bankName", unique =true,nullable = false, length = 45)
    private String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "idAddress", nullable = true)
    private Address idAddress;

    @ManyToOne
    @JoinColumn(name = "idBroker")
    private Broker idBroker;


    public Bank() {
    }
    public Bank(String name,Address address,Broker idBroker){
        this.name = name;
        this.idAddress = address;
        this.idBroker = idBroker;
    }

    public Broker getIdBroker() {
        return idBroker;
    }

    public void setIdBroker(Broker idBroker) {
        this.idBroker = idBroker;
    }
}
