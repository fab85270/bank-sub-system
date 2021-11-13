package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    /* Variables privées propres à une Bank*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private Long id;
    private String name;
    private Address address;
    @ManyToOne  //Plusieurs banques peuvent avoir une list de client
    @JoinColumn(name = "id", nullable = false)
    private List<Customer> listClient;
    @ManyToOne //Plusieurs banques peuvent avoir une liste de Clients pour un emprunt
    private List<Customer> listLoanClient;
    @OneToMany //Une banque peut posséder officers (employés) qui assureront la gestion/création de la simulation de crédit
    private List<Officer> listOfficer;


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

    public List<Customer> getListClient() {
        return listClient;
    }

    public void setListClient(List<Customer> listClient) {
        this.listClient = listClient;
    }

    public List<Customer> getListLoanClient() {
        return listLoanClient;
    }

    public void setListLoanClient(List<Customer> listLoanClient) {
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
