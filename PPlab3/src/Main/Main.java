package Main;
import Droids.ArmoredDroid;
import Droids.Droid;
import Droids.FastDroid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter 1 for 1v1 and 2 for teamfight");
        int a= sc.nextInt();
        switch (a){
            case 1:
                Droid first= new ArmoredDroid("Tank",100,30,10);
                Droid second = new FastDroid("Speedy",100,30,25);
                duel(first,second);
                break;
            case 2:
                Droid team1[]={new ArmoredDroid("Heavy",100,30,10),
                        new ArmoredDroid("Rock",100,30,10),
                        new FastDroid("Quicky",100,30,25)};
                Droid team2[]={new ArmoredDroid("Brut",100,30,10),
                        new FastDroid("Mcquinn",100,30,25),
                        new FastDroid("Shumaher",100,30,25)};
                teamfight(team1,team2);
                break;
            default: System.out.println("Wrong numba");
        }
    }
    static int duel(Droid first, Droid second){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        first.showDroid();
        System.out.println("VS");
        second.showDroid();
        while(true){
            if(first.isDead() && second.isDead()){
                System.out.println("DRAW");
                break;
            }
            if(first.isDead()){
                System.out.println("DROID "+second.getName()+" WINS!!!!");
                return 2;
            }
            if(second.isDead()){
                System.out.println("DROID "+first.getName()+" WINS!!!!");
                return 1;
            }
            System.out.println(first.takeDamage(second.getDamage()));
            System.out.println(second.takeDamage(first.getDamage()));
        }
        return 0;
    }
    static void teamfight(Droid[] firstTeam, Droid[] secondTeam){
        int wins1 =0,wins2 =0;
        System.out.println("FIRST TEAM:");
        for (int i = 0;i<firstTeam.length;i++){
            firstTeam[i].showDroid();
        }
        System.out.println("SECOND TEAM:");
        for (int i = 0;i<secondTeam.length;i++){
            secondTeam[i].showDroid();
        }

        for (int i = 0;i<secondTeam.length;i++){
            System.out.println("******ROUND "+(i+1)+"******");
            int temp = duel(firstTeam[i],secondTeam[i]);
            if(temp == 1)
                wins1++;
            if (temp == 2)
                wins2++;
        }
        if(wins1>wins2){
            System.out.println("!!!!!!!!!!!!TEAM 1 WON!!!!!!!!!!!");
        } else if (wins1<wins2) {
            System.out.println("!!!!!!!!!!!!TEAM 2 WON!!!!!!!!!!!");
        } else{
            System.out.println("!!!!!!!!!!!!DRAW!!!!!!!!!!!");
        }

    }
}
