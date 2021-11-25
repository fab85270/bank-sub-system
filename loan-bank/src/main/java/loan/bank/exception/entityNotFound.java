package loan.bank.exception;

public class entityNotFound extends Exception{
    public static class entityNotFoundException extends Throwable {
        public entityNotFoundException(int id) {
            super("Entité numéro " + id + " non trouvée");
        }
    }
}
