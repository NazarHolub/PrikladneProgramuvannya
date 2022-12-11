package models;


public class Stone {
    int id;
    String name;
    double carats;
    double opacity;
    double price;
    String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Stone(int id, String name, double carats, double opacity, double price, String color) {
        this.id = id;
        this.color = color;
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

    public double Cost() {
        return getPrice();
    }
}
