package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Dossier { //Dossier client qui sera ensuite tranmis aux banques pour étude et création de la simulation de financement (emprunt)

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDossier", nullable = false)
    private Long idDossier;

    @Column(name = "MonthlyIncome", nullable = false)
    private double NetMonthlyIncome; //Revenus mensuel net

    @Column(name = "2YearsIncome", nullable = false)
    private double Net2yearsIncome; //Revenus annuel net des deux dernières années.

    @Column(name = "createDate", nullable = false)
    private LocalDate creationDate;

    @Column(name = "completed", nullable = true)
    private Boolean completed;

    @Column(name = "lastModified", nullable = true)
    private LocalDate lastModified;

    @Column(name = "priceProperty", nullable = false)
    private double priceProperty;

    @Column(name = "downPayment", nullable = false)
    private double downPayment;

/*
*  Transmettre du JSON pour faire parvenir les différentes informations
* Faire une transciption du json envoyé par la banque vers le broket et le client en pdf pour améliorer la reception
* User va utiliser postMan
* Mettre toutes les entités dans broker et bank et les dto dans la partie commons
* supprimer user et definir officer et broker dans chacun des projets.
* Dans JPA, une chose permet de définir un type pour des fichiers(ici par exmeple pour les fichiers pour les
* comme la taxeHabitation dans les dossiers. Par exemple MONEY ( à se renseigner)
* */

    /*Constructeur de la classe Dossier */

    public Dossier(double netMonthlyIncome, double net2yearsIncome,double priceProperty, double downPayment) {
        NetMonthlyIncome = netMonthlyIncome;
        Net2yearsIncome = net2yearsIncome;
        //this.creationDate = ; ici mettre la date du jour actuelle (voir documentation de LocalDate)
        this.completed = false;
       // this.lastModified = lastModified; mettre à zero
        this.priceProperty = priceProperty;
        this.downPayment = downPayment;
    }

    public Dossier() {

    }

    /*Getters/Setters de la classe Dossier*/

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(Long idDossier) {
        this.idDossier = idDossier;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public double getNet2yearsIncome() {
        return Net2yearsIncome;
    }

    public void setNet2yearsIncome(double net2yearsIncome) {
        Net2yearsIncome = net2yearsIncome;
    }

    public double getNetMonthlyIncome() {
        return NetMonthlyIncome;
    }

    public void setNetMonthlyIncome(double netMonthlyIncome) {
        NetMonthlyIncome = netMonthlyIncome;
    }

    public double getPriceProperty() {
        return priceProperty;
    }

    public void setPriceProperty(double priceProperty) {
        this.priceProperty = priceProperty;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }
}
