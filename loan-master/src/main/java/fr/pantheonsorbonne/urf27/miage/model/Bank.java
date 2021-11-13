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

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idBank", nullable = false)
    private Address address;

    @ManyToOne(optional = false)  //Plusieurs banques peuvent avoir une list de client
    @JoinColumn(name = "idCustomer", nullable = false)  //Pas sûr de ceci=> à vérifier.
    private List<Customer> listCustomer;

    @ManyToOne(optional = false) //Plusieurs banques peuvent avoir une liste de Clients pour un emprunt
    @JoinColumn(name = "idCustomer", nullable = false)
    private List<Customer> listLoanCustomer;

    @ManyToOne(optional = false) //Plusieurs banques peuvent posséder une liste d'officers (employés) qui assureront la gestion/création de la simulation de crédit
    @JoinColumn(name = "idOfficer", nullable = false)
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

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public List<Customer> getListLoanCustomer() {
        return listLoanCustomer;
    }

    public void setListLoanCustomer(List<Customer> listLoanCustomer) {
        this.listLoanCustomer = listLoanCustomer;
    }

    public List<Officer> getListOfficer() {
        return listOfficer;
    }

    public void setListOfficer(List<Officer> listOfficer) {
        this.listOfficer = listOfficer;
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
                ", listClient=" + listCustomer +
                ", listLoanClient=" + listLoanCustomer +
                '}';
    }


}
