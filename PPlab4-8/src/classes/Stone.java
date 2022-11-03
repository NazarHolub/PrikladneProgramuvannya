package classes;

import java.io.Serializable;

public class Stone implements ICost, Serializable {
    String name;
    double carats;
    double opacity;
    double price;
    public Stone(String name, double carats, double opacity, double price) {
        this.name = name;
        this.carats = carats;
        this.opacity = opacity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public double getCarats() {
        return carats;
    }

    public void setCarats(double carats) {
        this.carats = carats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "name='" + name + '\'' +
                ", carats=" + carats +
                ", opacity=" + opacity +
                ", price=" + price +
                '}';
    }



    @Override
    public double Cost() {
        return getPrice();
    }
}
