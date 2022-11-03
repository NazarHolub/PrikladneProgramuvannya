import classes.Necklace;
import classes.Stone;

import java.io.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choice =0;
        File file = new File("text.txt");
        Necklace necklace = new Necklace();
        do{
            System.out.println("Choose an action: ");
            System.out.println("1 show necklace");
            System.out.println("2 add stone to necklace");
            System.out.println("3 write to file");
            System.out.println("4 read from file");
            System.out.println("5 sort necklace by price");
            System.out.println("6 Show necklace cost");
            System.out.println("7 Show necklace weight");
            System.out.println("0 exit");
            Scanner myObj = new Scanner(System.in);
            choice = myObj.nextInt();
            myObj.nextLine();
            switch(choice){
                case 1:
                    System.out.print(necklace.toString());
                    break;

                case 2:
                    System.out.println("Enter stone name: ");
                    String name = myObj.nextLine();
                    System.out.println("Enter stone carats: ");
                    double carats = myObj.nextDouble();

                    System.out.println("Enter stone opacity: ");
                    double opacity = myObj.nextDouble();

                    System.out.println("Enter stone price: ");
                    double price = myObj.nextDouble();
                    Stone stone = new Stone(name,carats,opacity,price);
                    necklace.AddStone(stone);
                    break;

                case 3:
                    writeObjectInFile(file,necklace);
                    break;

                case 4:
                    necklace = readObjectFromFile(file);
                    break;
                case 5:
                    necklace.SortByPrice();
                    break;
                case 6:
                    System.out.println(necklace.Cost());
                    break;
                case 7:
                    System.out.println(necklace.Weight());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("ERROR!");
            }
            System.out.println("\n\n");
        }while(choice != 0);
    }

    public static Necklace readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        Object result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = ois.readObject();
        }
        return (Necklace)result;
    }

    public static void writeObjectInFile(File file, Necklace necklace) throws IOException{
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(necklace);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
