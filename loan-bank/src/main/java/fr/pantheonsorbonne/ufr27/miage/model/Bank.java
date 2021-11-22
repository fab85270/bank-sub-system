package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private long idBank;

    @Column(name = "bankName", nullable = false)
    private String bankName;

    @OneToOne(optional = true)
    @JoinColumn(name="idAdress", nullable = true)
    private Address idAddress;

    /*Getter & Setter*/

    public long getIdBank() {
        return idBank;
    }

    public void setIdBank(long idBank) {
        this.idBank = idBank;
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

    public Bank(long idBank, String bankName, Address idAddress) {
        this.idBank = idBank;
        this.bankName = bankName;
        this.idAddress = idAddress;
    }
}
