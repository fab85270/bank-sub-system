package loan.bank.exception;

import loan.commons.dto.ProjectDTO;

public class LoanProposalException {
    public static class LoanProposalBankNotFoundException extends Throwable {
        public LoanProposalBankNotFoundException(int bankId) {
            super("La banque "+ bankId + "n'a pas été trouvé" );
        }
    }

    public static class LoanProposalRefusedException extends Throwable {
        public LoanProposalRefusedException(String description) {
            super(description);
        }
    }

    public static class ExpiredLoanProposalException extends Throwable {
        public ExpiredLoanProposalException() {
            super("La proposition de prêt n'est plus valable" );
        }
    }
}
