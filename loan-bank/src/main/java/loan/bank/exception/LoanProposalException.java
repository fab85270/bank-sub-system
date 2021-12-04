package loan.bank.exception;

public class LoanProposalException {
    public static class LoanProposalBankNotFoundException extends Throwable {
        public LoanProposalBankNotFoundException(int bankId) {
            super("La banque "+ bankId + "n'a pas été trouvé" );
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
