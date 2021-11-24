package loan.bank.model;

import javax.persistence.*;

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId", nullable = false)
    private Integer projectId;

    @OneToOne
    @JoinColumn(name = "realStateId", nullable = false)
    private RealEstate realStateId;

    @OneToOne
    @JoinColumn(name = "borrowerId", nullable = false)
    private Borrower borrowerId;

    @OneToOne
    @JoinColumn(name="brokerId",nullable=false)
    private Broker brokerId;

    



}
