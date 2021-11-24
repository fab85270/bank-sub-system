package loan.bank.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class LoanProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposalId", nullable = false)
    private Integer proposalId;

    @ManyToOne
    @JoinColumn(name = "projectId", nullable = false)
    private Project projectId;

    @OneToOne
    @JoinColumn(name = "brokerId", nullable = false)
    private Broker brokerId;

    @Column(name = "dateProposal", nullable = false)
    private Instant dateProposal;

    @Column(name = "endDate", nullable = false)
    private Instant dateFin;

    @Column(name = "Number", nullable = false)
    private String ;










}
