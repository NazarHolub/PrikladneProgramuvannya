package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StoneForTable {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty carats;
    private SimpleDoubleProperty opacity;
    private SimpleDoubleProperty price;
    private SimpleStringProperty color;

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id =new SimpleIntegerProperty( id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public double getCarats() {
        return carats.get();
    }

    public void setCarats(double carats) {
        this.carats = new SimpleDoubleProperty(carats);
    }

    public double getOpacity() {
        return opacity.get();
    }

    public void setOpacity(double opacity) {
        this.opacity = new SimpleDoubleProperty(opacity);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price = new SimpleDoubleProperty(price);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color = new SimpleStringProperty(color);
    }

    public StoneForTable(int id, String name, double carats, double opacity, double price, String color) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.carats = new SimpleDoubleProperty(carats);
        this.opacity = new SimpleDoubleProperty(opacity);
        this.price = new SimpleDoubleProperty(price);
        this.color = new SimpleStringProperty(color);
    }
}
