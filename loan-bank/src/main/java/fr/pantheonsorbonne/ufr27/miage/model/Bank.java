package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private long idBank;

    @Column(name = "bankName", nullable = false)
    private int bankName;

    @Column(name = "AdressID", nullable = false)
    private int AddressID;

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

    public int getBankName() {
        return bankName;
    }

    public void setBankName(int bankName) {
        this.bankName = bankName;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    /*Constructeur*/
    public Bank(){}

    public Bank(long idBank, int bankName, int addressID, Address idAddress) {
        this.idBank = idBank;
        this.bankName = bankName;
        AddressID = addressID;
        this.idAddress = idAddress;
    }
}
