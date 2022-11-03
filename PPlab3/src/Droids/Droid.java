package Droids;

public class Droid {
    String name;
    int health;
    int damage;

    public Droid(){}
    public Droid(String n, int h, int d){
        this.name =n;
        health =h;
        damage =d;
    }

    public String showDroid(){
        return "droid:"+"\nname: "+name+" health: "+health+" damage: "+damage;
    }
    public String takeDamage(int dmg){
        health -= dmg;
        return name + "is damaged by " + dmg;
    }

    public boolean isDead(){
        return health<=0;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
