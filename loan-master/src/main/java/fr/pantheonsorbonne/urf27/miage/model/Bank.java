package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import javax.ws.rs.client.Client;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    /* Variables privées propres à une Bank*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Address address;
    @ManyToOne  //Plusieurs banques peuvent avoir une list de client
    private List<Client> listClient;
    @ManyToOne //Plusieurs banques peuvent avoir une liste de Clients pour un emprunt
    private List<Client> listLoanClient;

    /* Constructeurs de la classe Bank */

    public Bank(){}

    public Bank(String name,Address address){
        this.name = name;
        this.address = address;
        /* Lors de sa création, une banque ne possède pas de Clients*/
        this.listClient = new ArrayList<Client>();
        this.listLoanClient = new ArrayList<Client>();
    }

    /*Accesseurs/Getters de la classe Bank*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    public List<Client> getListLoanClient() {
        return listLoanClient;
    }

    public void setListLoanClient(List<Client> listLoanClient) {
        this.listLoanClient = listLoanClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", listClient=" + listClient +
                ", listLoanClient=" + listLoanClient +
                '}';
    }
}
