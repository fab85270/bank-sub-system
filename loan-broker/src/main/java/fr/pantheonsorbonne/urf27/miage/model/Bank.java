package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private Integer idBank;

    @Column(name = "bankName", nullable = false, length = 45, unique = true)
    private String bankName;

    @OneToOne(optional = true)
    @JoinColumn(name = "idAddress", nullable = true)
    private Address idAddress;

    @ManyToOne
    @JoinColumn(name = "idBroker")
    private Broker idBroker;


    public Bank() {
    }

    public Bank(String name, Address idAddress, Broker idBroker){
        this.bankName = name;
        this.idAddress = idAddress;
        this.idBroker = idBroker;
    }

    public String getName() {
        return bankName;
    }

    public void setName(String name) {
        this.bankName = name;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    public void setIdBroker(Broker idBroker) {
        this.idBroker = idBroker;
    }

    public Broker getIdBroker() {
        return idBroker;
    }

}
