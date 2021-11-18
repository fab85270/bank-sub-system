package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
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

  /*  @ManyToOne(optional = false)  //Plusieurs banques peuvent avoir une list de client
    @JoinColumn(name = "idCustomer", nullable = false)  //Pas sûr de ceci=> à vérifier.
    private List<Customer> listCustomer;
*/
    @ManyToOne(optional = false) //Plusieurs banques peuvent avoir une liste de Clients pour un emprunt
    @JoinColumn(name = "idCustomer", nullable = false)
    private List<Borrower> listLoanBorrower;

    @ManyToOne(optional = false) //Plusieurs banques peuvent posséder une liste d'officers (employés) qui assureront la gestion/création de la simulation de crédit
    @JoinColumn(name = "idOfficer", nullable = false)
    private List<Officer> listOfficer;

    
    public Bank(Long id, String name, Address address, List<Borrower> listLoanBorrower, List<Officer> listOfficer) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.listLoanBorrower = listLoanBorrower;
        this.listOfficer = listOfficer;
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


    public List<Borrower> getListLoanBorrower() {
        return listLoanBorrower;
    }

    public void setListLoanBorrower(List<Borrower> listLoanBorrower) {
        this.listLoanBorrower = listLoanBorrower;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", listLoanBorrower=" + listLoanBorrower +
                ", listOfficer=" + listOfficer +
                '}';
    }
}