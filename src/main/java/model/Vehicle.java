package model;

import enums.Color;

public class Vehicle implements java.io.Serializable {

    private int id;
    private Make make;
    private Model model;
    private Color color;
    private int year;
    private String description;

    //constructor

    public Vehicle() {
        this.setId(0);
        this.setMake(null);
        this.setModel(null);
        this.setColor(Color.NONE);
        this.setYear(1900);
        this.setDescription("SEM DESCRICAO");
    }
    
    
    public Vehicle(int id, Make make, Model model, Color color, int year, String description) {
        this.setId(id);
        this.setMake(make);
        this.setModel(model);
        this.setColor(color);
        this.setYear(year);
        this.setDescription(description);
    }

    //getters
    public int getId() {
        return id;
    }

    public Make getMake() {
        return make;
    }

    public Model getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    //setters
    public void setId(int id) {
        this.id = id <= 0 ? 0 : id;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year < 1900 ? 1900 : year;
    }

    public void setDescription(String description) {
        this.description = description.trim().isEmpty() ? "SEM DESCRIÇÃO" : description.toUpperCase();
    }

    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final Vehicle other = (Vehicle) obj;
        return this.id == other.id;
    }
    //

    @Override
    public String toString() {
        return model.toString();
    }

}
