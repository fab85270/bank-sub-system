package fr.pantheonsorbonne.ufr27.miage.exception;

public class entityNotFound extends Exception{
    public static class entityNotFoundException extends Throwable {
        public entityNotFoundException(int id) {
            super("No available seat for " + id);
        }
    }
}
