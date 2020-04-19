package entity;

import java.util.Date;
import java.util.Objects;

public class Studentes {
    private String name;
    private String surname;
    private String nomber_grup;
    private Date date_aprobarse;
    private int id;
    private int status=1;

    public Studentes() {
    }

    @Override
    public String toString() {
        return "Studentes{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nomber_grup='" + nomber_grup + '\'' +
                ", date_aprobarse=" + date_aprobarse +
                ", id=" + id +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studentes studentes = (Studentes) o;
        return id == studentes.id &&
                status == studentes.status &&
                Objects.equals(name, studentes.name) &&
                Objects.equals(surname, studentes.surname) &&
                Objects.equals(nomber_grup, studentes.nomber_grup) &&
                Objects.equals(date_aprobarse, studentes.date_aprobarse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nomber_grup, date_aprobarse, id, status);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNomber_grup(String nomber_grup) {
        this.nomber_grup = nomber_grup;
    }

    public void setDate_aprobarse(Date date_aprobarse) {
        this.date_aprobarse = date_aprobarse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNomber_grup() {
        return nomber_grup;
    }

    public Date getDate_aprobarse() {
        return date_aprobarse;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public Studentes(String name, String surname, String nomber_grup, Date date_aprobarse, int id, int status) {
        this.name = name;
        this.surname = surname;
        this.nomber_grup = nomber_grup;
        this.date_aprobarse = date_aprobarse;
        this.id = id;
        this.status = status;
    }
}


