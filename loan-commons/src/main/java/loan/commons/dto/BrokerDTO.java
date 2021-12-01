package loan.commons.dto;

public class BrokerDTO {

    int brokerId;

    int numberOfValidProposals;

    public BrokerDTO() {
        this.numberOfValidProposals = 0 ;
    }

    public int getBrokerId() {
        return brokerId;
    }

    public int getNumberOfValidProposals() {
        return numberOfValidProposals;
    }

    public void setNumberOfValidProposals(int numberOfValidProposals) {
        this.numberOfValidProposals = numberOfValidProposals;
    }
}
