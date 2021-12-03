package fr.pantheonsorbonne.urf27.miage.exception;

public class BankExceptions extends Exception {

    /* Cette banque existe déja en base de donnée*/
    public static class BankAlreadyExists extends Throwable {
        public BankAlreadyExists(String bankName) {

            super("Bank " + bankName + " already exists.");
        }
    }
    /* Aucune banque n'a été trouvée en base de donnée */
    public static class BankNotFound extends Throwable {
        public BankNotFound(String bankName) {
            super("Bank "+ bankName+ " not found.");
        }
    }

    /* Aucunes banques n'ont été trouvées en base de données */
    public static class BanksNotFound extends Throwable {
        public BanksNotFound() {
            super("Banks not found.");
        }
    }

    /* Aucune banque n'est associée à cet ID */
    public static class BanksNotFoundId extends Throwable {
        public BanksNotFoundId(int id) {
            super("no bank is associated with this ID : "+ id);
        }
    }
}