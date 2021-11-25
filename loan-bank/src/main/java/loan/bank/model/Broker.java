package loan.bank.model;

import javax.persistence.*;


@Entity
public class Broker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brokerId", nullable = false)
    private Integer brokerId;

    @Column(name = "numberOfValidProposals", nullable = false)
    private int numberOfValidProposals;


    public Broker() {
        this.numberOfValidProposals = 0;
    }

    public int getNumberOfValidProposals() {
        return numberOfValidProposals;
    }

    public void setNumberOfValidProposals(int numberOfValidProposals) {
        this.numberOfValidProposals = numberOfValidProposals;
    }
}