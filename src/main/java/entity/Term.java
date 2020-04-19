package entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Term {
    private LinkedList<Discipline> disciplina = new LinkedList<Discipline>();
    private String name_term;
    private double tiempo_term;
//    private String disciplina;
    private int id_discipline;
    private int id;
    private int status=1;

    public LinkedList<Discipline> getDiscipList() {
        return disciplina;
    }

    public void setDiscipList(LinkedList<Discipline> discipList) {
        this.disciplina = discipList;
    }

    public void addDiscipline (Discipline discipline){

        disciplina.add(discipline);
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return Double.compare(term.tiempo_term, tiempo_term) == 0 &&
                id_discipline == term.id_discipline &&
                id == term.id &&
                status == term.status &&
                Objects.equals(disciplina, term.disciplina) &&
                Objects.equals(name_term, term.name_term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplina, name_term, tiempo_term,  id_discipline, id, status);
    }

    @Override
    public String toString() {
        return "Term{" +
                "discipList=" + disciplina +
                ", name_term='" + name_term + '\'' +
                ", tiempo_term=" + tiempo_term +
                ", id_discipline=" + id_discipline +
                ", id=" + id +
                ", status=" + status +
                '}';
    }

    public void setName_term(String name_term) {
        this.name_term = name_term;
    }

    public void setTiempo_term(double tiempo_term) {
        this.tiempo_term = tiempo_term;
    }



    public void setId_discipline(int id_discipline) {
        this.id_discipline = id_discipline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName_term() {
        return name_term;
    }

    public double getTiempo_term() {
        return tiempo_term;
    }


    public int getId_discipline() {
        return id_discipline;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }
}
