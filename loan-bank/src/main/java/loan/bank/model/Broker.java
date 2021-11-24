package loan.bank.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Broker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brokerId", nullable = false)
    private Integer brokerId;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "principalLimit", nullable = false)
    private Instant principalLimit;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "duration", nullable = false) //En nombre de mois
    private int duration;

    /* A voir */





}
