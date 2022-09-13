package Droids;

import java.util.Random;

public class FastDroid extends Droid{
    int dodgeChance;

    public FastDroid(String n, int h, int d, int dc){
        name =n;
        health =h;
        damage =d;
        dodgeChance =dc;
    }

    public String takeDamage(int dmg){
        Random random = new Random();
        int chance = random.nextInt(100);
        if(chance <= dodgeChance)
            return this.name + "is damaged by " + 0;
        health -= dmg;
        return name + "is damaged by " + dmg;
    }

    public void showDroid(){
        System.out.println("     ,------.._\n" +
                "         (      o  o)\n" +
                "        _.`--------'\n" +
                "      .~  ~.   . `-.-~~~-.___      ____\n" +
                "      (     )   \\       \\    ~~~~~~ .--'\n" +
                "    .-~    /     ) ..___.-----------~\n" +
                "   /     > `-._  |/\n" +
                "  (      \\     ~~--._\n" +
                "   `-.    \\   //     ~~--.\n" +
                "      `-.  ~-.\\\\ /~-._  /X\\\n" +
                "         `-=-._:=--. / |XOX|\n" +
                "     LS    |  |     ~-._\\X/\n" +
                "         .--.-~~-.\n" +
                "        / ++| xx |\n" +
                "       / ++/| xx |");
        System.out.println("name: "+name+" health: "+health+" damage: "+damage+" dodge chance: "+dodgeChance);
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

}
