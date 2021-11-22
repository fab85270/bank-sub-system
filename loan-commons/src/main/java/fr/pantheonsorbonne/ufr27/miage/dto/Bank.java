package fr.pantheonsorbonne.ufr27.miage.dto;

public class Bank {

    private Integer idBank;

    private String name;

    private int idAddress;

    private int idBroker;

    public Bank() {
    }

    public Bank(Integer idBank, String name, int idAddress, int idBroker) {
        this.idBank = idBank;
        this.name = name;
        this.idAddress = idAddress;
        this.idBroker = idBroker;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdBroker() {
        return idBroker;
    }

    public void setIdBroker(int idBroker) {
        this.idBroker = idBroker;
    }
}
