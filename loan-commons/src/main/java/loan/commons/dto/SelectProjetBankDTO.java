package loan.commons.dto;

/* Il s'agira du DTO contenant le numéro(identifiant) du project Client qui sera envoyé à la Bank*/

public class SelectProjetBankDTO {
    int idProject;

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Override
    public String toString() {
        return "SelectProjetBankDTO{" +
                "idProject=" + idProject +
                '}';
    }
}
