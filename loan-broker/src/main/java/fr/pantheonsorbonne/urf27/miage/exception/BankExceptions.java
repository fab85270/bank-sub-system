package fr.pantheonsorbonne.urf27.miage.exception;

public class BankExceptions extends Exception {

    public static class BankAlreadyExists extends Throwable {
        public BankAlreadyExists(String bankName) {
            super("Bank " + bankName + " already exists.");
        }

    }
}
