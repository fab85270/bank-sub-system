package loan.bank.exception;

public class LoanProposalException {
    public static class LoanProposalNotFoundException extends Throwable {
        public LoanProposalNotFoundException(int projectId) {
            super("La proposition de prêt "+ projectId + "n'a pas été trouvé dans la BDD " );
        }
    }

    public static class LoanProposalRefusedException extends Throwable {
        public LoanProposalRefusedException() {
            super("Aucune proposition de prêt ne peut être proposée, le client n'est pas éligible" );
        }
    }

    public static class ExpiredLoanProposalException extends Throwable {
        public ExpiredLoanProposalException() {
            super("La proposition de prêt n'est plus valable" );
        }
    }
}
