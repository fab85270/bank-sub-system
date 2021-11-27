package loan.commons.dto;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class DummyDTO {
    String description;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    LocalDate dateDepart;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    LocalDate dateFin;
    double sommeVoulu;
    String workStatut;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getSommeVoulu() {
        return sommeVoulu;
    }

    public void setSommeVoulu(double sommeVoulu) {
        this.sommeVoulu = sommeVoulu;
    }

    public String getWorkStatut() {
        return workStatut;
    }

    public void setWorkStatut(String workStatut) {
        this.workStatut = workStatut;
    }

    @Override
    public String toString() {
        return "DummyDTO{" +
                "description='" + description + '\'' +
                ", dateDepart=" + dateDepart +
                ", dateFin=" + dateFin +
                ", sommeVoulu=" + sommeVoulu +
                ", workStatut='" + workStatut + '\'' +
                '}';
    }
}
