package entity;

import java.util.Objects;

public class Language {
    private int id;
    private String language;
    private String shot_name;

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", shot_name='" + shot_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return id == language1.id &&
                Objects.equals(language, language1.language) &&
                Objects.equals(shot_name, language1.shot_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, shot_name);
    }

    public String getShot_name() {
        return shot_name;
    }

    public void setShot_name(String shot_name) {
        this.shot_name = shot_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
