package model;

import java.util.Objects;

public class Make implements java.io.Serializable  {

    private int id;
    private String name;

    //constructor
    public Make() {
        this.setId(0);
        this.setName("SEM NOME");
    }

    public Make(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //setters
    public void setId(int id) {
        this.id = id <= 0 ? 0 : id;
    }

    public void setName(String name) {
        this.name = name.trim().isEmpty() ? "SEM NOME" : name.toUpperCase();
    }

    //
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Make other = (Make) obj;
        return Objects.equals(this.id, other.id);
    }

    //
    @Override
    public String toString() {
        return name;
    }
}
