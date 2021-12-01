package loan.bank.exception;

public class LoanProposalException {
    public static class LoanProposalNotFoundException extends Throwable {
        public LoanProposalNotFoundException(int projectId) {
            super("La proposition de prêt "+ projectId + "n'a pas été trouvé dans la BDD " );
        }
    }
}
