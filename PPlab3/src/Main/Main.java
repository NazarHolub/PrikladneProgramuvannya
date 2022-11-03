package Main;
import Droids.ArmoredDroid;
import Droids.Droid;
import Droids.FastDroid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Univer\\PrikladneProgramuvannya\\projects\\PPlab3\\src\\Battle.txt"));

                    duel(first,second,writer);

                    writer.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Droid[] team1 ={new ArmoredDroid("Heavy",100,30,10),
                        new ArmoredDroid("Rock",100,30,10),
                        new FastDroid("Quicky",100,30,25)};
                Droid[] team2 ={new ArmoredDroid("Brut",100,30,10),
                        new FastDroid("Mcquinn",100,30,25),
                        new FastDroid("Shumaher",100,30,25)};
                try {
                    teamfight(team1,team2);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                break;
            default: System.out.println("Wrong numba");
        }
    }
    static int duel(Droid first, Droid second,BufferedWriter writer) throws IOException {

            System.out.println(first.showDroid());
            writer.write(first.showDroid());
            writer.write("\nVS\n");
            System.out.println("VS");
            writer.write(second.showDroid());
            second.showDroid();
            while (true) {
                if (first.isDead() && second.isDead()) {
                    writer.write("DRAW");
                    System.out.println("DRAW");
                    break;
                }
                if (first.isDead()) {
                    System.out.println("DROID " + second.getName() + " WINS!!!!");
                    writer.write("DROID " + second.getName() + " WINS!!!!");
                    return 2;
                }
                if (second.isDead()) {
                    System.out.println("DROID " + first.getName() + " WINS!!!!");
                    writer.write("DROID " + first.getName() + " WINS!!!!");
                    return 1;
                }
                String a = first.takeDamage(second.getDamage());
                String b =second.takeDamage(first.getDamage());
                System.out.println(a);
                System.out.println(b);
                writer.write(a +"\n");
                writer.write(b+"\n");
            }
        return 0;
    }
    static void teamfight(Droid[] firstTeam, Droid[] secondTeam) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Univer\\PrikladneProgramuvannya\\projects\\PPlab3\\src\\Battle.txt"));
        int wins1 =0,wins2 =0;
        System.out.println("FIRST TEAM:");
        writer.write("FIRST TEAM:");
        for (int i = 0;i<firstTeam.length;i++){
            firstTeam[i].showDroid();
            writer.write(firstTeam[i].showDroid());
        }
        System.out.println("SECOND TEAM:");
        writer.write("Second TEAM:");
        for (int i = 0;i<secondTeam.length;i++){
            secondTeam[i].showDroid();
            writer.write(secondTeam[i].showDroid());
        }

        for (int i = 0;i<secondTeam.length;i++){
            System.out.println("******ROUND "+(i+1)+"******");
            writer.write("******ROUND "+(i+1)+"******\n");
            int temp = duel(firstTeam[i],secondTeam[i],writer);
            if(temp == 1)
                wins1++;
            if (temp == 2)
                wins2++;
        }
        if(wins1>wins2){
            System.out.println("!!!!!!!!!!!!TEAM 1 WON!!!!!!!!!!!");
            writer.write("!!!!!!!!!!!!TEAM 1 WON!!!!!!!!!!!\n");
        } else if (wins1<wins2) {
            System.out.println("!!!!!!!!!!!!TEAM 2 WON!!!!!!!!!!!");
            writer.write("!!!!!!!!!!!!TEAM 2 WON!!!!!!!!!!!\n");
        } else{
            System.out.println("!!!!!!!!!!!!DRAW!!!!!!!!!!!");
            writer.write("!!!!!!!!!!!!DRAW!!!!!!!!!!!\n");
        }
        writer.close();
    }
}
