package loan.bank.exception;

public class ProjectException extends Exception{

    public static class ExpiredProjectException extends Throwable {
        public ExpiredProjectException(int projectId) {
            super("Le projet de prêt n'est plus valide pour le projet " + projectId);
        }
    }
}
