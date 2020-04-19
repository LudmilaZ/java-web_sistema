package entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class ProgresosDeStudentes {
    private  int id;
    private  int idStud;
    private String surname;
    private String name;
    private String nomber_grup;
    private Date date_aprobarse;
    private LinkedList<DisciplinaEvalucion> disciplinaEvalucions = new LinkedList<DisciplinaEvalucion>();
    private String name_term;
    private double valoracionMedia;

    public ProgresosDeStudentes() {
    }

    @Override
    public String toString() {
        return "ProgresosDeStudentes{" +
                "id=" + id +
                ", idStud=" + idStud +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", nomber_grup='" + nomber_grup + '\'' +
                ", date_aprobarse=" + date_aprobarse +
                ", disciplinaEvalucions=" + disciplinaEvalucions +
                ", name_term='" + name_term + '\'' +
                ", valoracionMedia=" + valoracionMedia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgresosDeStudentes that = (ProgresosDeStudentes) o;
        return id == that.id &&
                idStud == that.idStud &&
                Double.compare(that.valoracionMedia, valoracionMedia) == 0 &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(nomber_grup, that.nomber_grup) &&
                Objects.equals(date_aprobarse, that.date_aprobarse) &&
                Objects.equals(disciplinaEvalucions, that.disciplinaEvalucions) &&
                Objects.equals(name_term, that.name_term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStud, surname, name, nomber_grup, date_aprobarse, disciplinaEvalucions, name_term, valoracionMedia);
    }

    public int getIdStud() {
        return idStud;
    }

    public void setIdStud(int idStud) {
        this.idStud = idStud;
    }

    public ProgresosDeStudentes(int id, int idStud, String surname, String name, String nomber_grup, Date date_aprobarse, LinkedList<DisciplinaEvalucion> disciplinaEvalucions, String name_term, double valoracionMedia) {
        this.id = id;
        this.idStud = idStud;
        this.surname = surname;
        this.name = name;
        this.nomber_grup = nomber_grup;
        this.date_aprobarse = date_aprobarse;
        this.disciplinaEvalucions = disciplinaEvalucions;
        this.name_term = name_term;
        this.valoracionMedia = valoracionMedia;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }
    public void sumValoracionMedia(double summ){
        valoracionMedia=  valoracionMedia+summ;
    }

    public ProgresosDeStudentes(int id, String surname, String name, String nomber_grup, Date date_aprobarse, LinkedList<DisciplinaEvalucion> disciplinaEvalucions, String name_term, double valoracionMedia) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.nomber_grup = nomber_grup;
        this.date_aprobarse = date_aprobarse;
        this.disciplinaEvalucions = disciplinaEvalucions;
        this.name_term = name_term;
        this.valoracionMedia = valoracionMedia;
    }

    public ProgresosDeStudentes(int id, String surname, String name, String nomber_grup, Date date_aprobarse, LinkedList<DisciplinaEvalucion> disciplinaEvalucions, String name_term) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.nomber_grup = nomber_grup;
        this.date_aprobarse = date_aprobarse;
        this.disciplinaEvalucions = disciplinaEvalucions;
        this.name_term = name_term;
    }



    public void addDiscipline (DisciplinaEvalucion discipline){

        disciplinaEvalucions.add(discipline);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNomber_grup() {
        return nomber_grup;
    }

    public void setNomber_grup(String nomber_grup) {
        this.nomber_grup = nomber_grup;
    }

    public Date getDate_aprobarse() {
        return date_aprobarse;
    }

    public void setDate_aprobarse(Date date_aprobarse) {
        this.date_aprobarse = date_aprobarse;
    }

    public LinkedList<DisciplinaEvalucion> getDisciplinaEvalucions() {
        return disciplinaEvalucions;
    }

    public void setDisciplinaEvalucions(LinkedList<DisciplinaEvalucion> disciplinaEvalucions) {
        this.disciplinaEvalucions = disciplinaEvalucions;
    }

    public String getName_term() {
        return name_term;
    }

    public void setName_term(String name_term) {
        this.name_term = name_term;
    }
}
