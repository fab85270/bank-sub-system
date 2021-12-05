package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bankId", nullable = false)
    private Integer bankId;

    @Column(name = "bankName", nullable = false, length = 45, unique = true)
    private String bankName;

    @OneToOne(optional = true)
    @JoinColumn(name = "addressId", nullable = true)
    private Address addressId;


    public Bank() {
    }

    public Bank(String name, Address idAddress){
        this.bankName = name;
        this.addressId = idAddress;
    }

    /*Getter & Setters */
    public Integer getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public Address getAddressId() {
        return addressId;
    }

    public String getName() {
        return bankName;
    }

    public void setName(String name) {
        this.bankName = name;
    }

    public Address getIdAddress() {
        return addressId;
    }

    public void setIdAddress(Address idAddress) {
        this.addressId = idAddress;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
