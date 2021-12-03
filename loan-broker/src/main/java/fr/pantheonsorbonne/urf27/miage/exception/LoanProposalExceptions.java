
package fr.pantheonsorbonne.urf27.miage.exception;

public class LoanProposalExceptions {

    /* Aucun projet correspondant à cet ID n'a été trouvé en base de données */

    public static class LoanProposalsNotFound extends Throwable {
        public LoanProposalsNotFound() {

            super("Loan proposals not found");
        }
    }
}