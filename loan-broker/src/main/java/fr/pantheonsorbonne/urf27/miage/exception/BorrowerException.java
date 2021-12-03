package fr.pantheonsorbonne.urf27.miage.exception;

public class BorrowerException extends Exception {

    /* Aucuns projets n'ont été trouvés en base de données */
    public static class BorrowerNotFound extends Throwable {
        public BorrowerNotFound(String mail) {
            super("Borrower not found with the mail : "+mail);
        }
    }




}