package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private long idBank;

    @Column(name = "bankName", nullable = false, length = 45)
    private String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "idAddress", nullable = true)
    private Address idAddress;

    @ManyToOne
    @JoinColumn(name = "idBroker")
    private Broker idBroker;


    public Bank() {
    }

    public Broker getIdBroker() {
        return idBroker;
    }

    public void setIdBroker(Broker idBroker) {
        this.idBroker = idBroker;
    }
}