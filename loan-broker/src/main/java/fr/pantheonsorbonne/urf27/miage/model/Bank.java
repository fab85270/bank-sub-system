package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private Integer idBank;

    @Column(name = "bankName", nullable = false, length = 45, unique = true)
    private String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "idAddress", nullable = true)
    private Address idAddress;

    @ManyToOne
    @JoinColumn(name = "idBroker")
    private Broker idBroker;


    public Bank() {
    }

    public Bank(String name, Address idAddress, Broker idBroker){
        this.name = name;
        this.idAddress = idAddress;
        this.idBroker = idBroker;
    }

    public Broker getIdBroker() {
        return idBroker;
    }

}
