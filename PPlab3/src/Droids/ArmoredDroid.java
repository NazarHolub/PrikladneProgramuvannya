package Droids;

public class ArmoredDroid extends Droid{
    int armor;

    public ArmoredDroid(String n, int h, int d, int a){
        name =n;
        health =h;
        damage =d;
        armor =a;
    }

    public String takeDamage(int dmg){
        dmg -=armor;
        health -= dmg;
        return name + "is damaged by " + dmg;
    }

    public String showDroid(){
        return"\n           ____\n" +
                "          / ___\\\n" +
                "         |: =O =O\n" +
                "         |:: __ |\n" +
                "          \\_/LLL\\\n" +
                "    __ __./:__:\\.__ __\n" +
                "   (%%i \\ |<__>| / i%%)\n" +
                "   |--|:/\\/ :: \\/\\:|--|\n" +
                "   |  |:  :====:  :|  |\n" +
                "  .':.'Y-\" |::| \"-Y`.:`.\n" +
                "  |__| | : |__|.-.| |__|\n" +
                "  (%%) | : /++\\`-'! (%%)\n" +
                "   \\  \\|n._\\++/_.n| /  /\n" +
                "    \\ xT::::--::::T/  /\n" +
                "     \\Xl-. `\"\"' .-lXX'\n" +
                "       |: \\    / :|\n" +
                "       |:  i--i  :|\n" +
                "       |:  |  |  :| LS\n" +
                "       |___|  |__;|\n" +
                "       P%%%Y  P%%%Y\n" +
                "       b%%%d  b%%%d   \n" +
                "       |   |  |   |"+
                "name: "+name+" health: "+health+" damage: "+damage+" armor: "+armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

}
