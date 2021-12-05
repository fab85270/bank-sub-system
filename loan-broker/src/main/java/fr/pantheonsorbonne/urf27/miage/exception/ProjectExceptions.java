package fr.pantheonsorbonne.urf27.miage.exception;

public class ProjectExceptions extends Exception {

    /* Aucuns projets n'ont été trouvés en base de données */
    public static class ProjectsNotFound extends Throwable {
        public ProjectsNotFound() {
            super("Projects not found.");
        }
    }

    /* Aucun projet correspondant à cet ID n'a été trouvé en base de données */
    public static class ProjectNotFoundId extends Throwable {
        public ProjectNotFoundId(int idProject) {
            super("No project exists for the identifier : " + idProject);
        }
    }

    public static class ProjectPublicKeyNotFound extends Throwable {
        public ProjectPublicKeyNotFound(String publicKey) {
            super("No project exists for the publicKey : " + publicKey);
        }
    }


}