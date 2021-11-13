package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.Instant;


@Entity
public class LoanSimulation {

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoanSimulation", nullable = false)
    private Long idLoanSimulation;

    @OneToOne(optional = false) //Une LoanSimulation concerne un dossier
    @JoinColumn(name = "idDossier", nullable = false)
    private Dossier dossier;

    @Column(name = "dateSimulation", nullable = false)
    private Instant dateSimulation;

    @Column(name = "interestRate", nullable = false)
    private double interestRate;




}
