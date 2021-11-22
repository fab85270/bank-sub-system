package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private Integer idBank;

    @Column(name = "bankName", nullable = false, unique=true)
    private String bankName;

    @OneToOne(optional = true)
    @JoinColumn(name="idAdress", nullable = true)
    private Address idAddress;

    /*Getter & Setter*/

    public Integer getIdBank() {
        return idBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    /*Constructeur*/
    public Bank(){}

    public Bank( String bankName, Address idAddress) {
        this.bankName = bankName;
        this.idAddress = idAddress;
    }
}
