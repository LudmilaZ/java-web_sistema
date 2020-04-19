package entity;

import java.util.Objects;

public class Discipline {
    private String discipline;
    private int id;
    private int status=1;
private int isUseInTerm=0;

    @Override
    public String toString() {
        return "Discipline{" +
                "discipline='" + discipline + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", isUseInTerm=" + isUseInTerm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return id == that.id &&
                status == that.status &&
                isUseInTerm == that.isUseInTerm &&
                Objects.equals(discipline, that.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discipline, id, status, isUseInTerm);
    }

    public int getIsUseInTerm() {
        return isUseInTerm;
    }

    public void setIsUseInTerm(int isUseInTerm) {
        this.isUseInTerm = isUseInTerm;
    }

    public Discipline(String discipline, int id, int status, int isUseInTerm) {
        this.discipline = discipline;
        this.id = id;
        this.status = status;
        this.isUseInTerm = isUseInTerm;
    }

    public Discipline() {
    }

    public Discipline(String discipline, int id) {
        this.discipline = discipline;
        this.id = id;
    }

    public Discipline(String discipline, int id, int status) {
        this.discipline = discipline;
        this.id = id;
        this.status = status;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
