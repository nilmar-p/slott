package model;

public class Model implements java.io.Serializable {
    
    private int id;
    private String name;
    private Make make;

    //constructor
    public Model() {
        this.setId(0);
        this.setName("SEM NOME");
        this.setMake(null);
    }
    
    public Model(int id, String name, Make make) {
        this.setId(id);
        this.setName(name);
        this.setMake(make);
    }

    //getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Make getMake() {
        return make;
    }

    //setters
    public void setId(int id) {
        this.id = id <= 0 ? 0 : id;
    }
    
    public void setName(String name) {
        this.name = name.trim().isEmpty() ? "SEM NOME" : name.toUpperCase();
    }
    
    public void setMake(Make make) {
        this.make = make;
    }

    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final Model other = (Model) obj;
        return this.id == other.id;
    }

    //
    @Override
    public String toString() {
        return name;
    }
    
}
