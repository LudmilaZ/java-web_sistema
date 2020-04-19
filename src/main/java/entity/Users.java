package entity;

import java.util.Objects;

public class Users {
    private String login;
    private String pasword;
    private String role;
    private int id;
    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", pasword='" + pasword + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(login, users.login) &&
                Objects.equals(pasword, users.pasword) &&
                Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, pasword, role, id);
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }



    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPasword() {
        return pasword;
    }

    public int getId() {
        return id;
    }
}
