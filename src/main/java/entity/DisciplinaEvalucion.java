package entity;

import java.util.Objects;

public class DisciplinaEvalucion {
    private Discipline discipline;
    private int evalucion;

    public void setEvalucion(int evalucion) {
        this.evalucion = evalucion;
    }

    public DisciplinaEvalucion() {
    }

    public DisciplinaEvalucion(Discipline discipline, byte evalucion) {
        this.discipline = discipline;
        this.evalucion = evalucion;
    }



    @Override
    public String toString() {
        return "DisciplinaEvalucion{" +
                "discipline=" + discipline +
                ", evalucion=" + evalucion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinaEvalucion that = (DisciplinaEvalucion) o;
        return evalucion == that.evalucion &&
                Objects.equals(discipline, that.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discipline, evalucion);
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setEvalucion(byte evalucion) {
        this.evalucion = evalucion;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public int getEvalucion() {
        return evalucion;
    }
}
