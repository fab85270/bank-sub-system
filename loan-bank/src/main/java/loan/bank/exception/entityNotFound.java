package loan.bank.exception;


/* Definition de l'exception métier */
public class entityNotFound extends Exception{
    public static class entityNotFoundException extends Throwable {
        public entityNotFoundException(int id) {
            super("No available seat for " + id);
        }
    }
}
