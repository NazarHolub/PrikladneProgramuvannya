import Commands.*;
import classes.Necklace;
import classes.Stone;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choice =0;
        File file = new File("D:\\Univer\\PrikladneProgramuvannya\\projects\\PPlab4-8\\src\\resources\\text.txt");
        Necklace necklace = new Necklace();
        Map<Integer, Command> commands = new HashMap<>();
        commands.put(100, new ShowActionsCommand());
        commands.put(1, new ShowNecklaceCommand(necklace));
        commands.put(2, new AddStoneCommand(necklace));
        commands.put(3, new WriteInFileCommand(necklace,file));
        commands.put(4, new ReadFromFileCommand(necklace,file));
        commands.put(5, new SortCommand(necklace));
        commands.put(6, new ShowCostCommand(necklace));
        commands.put(7, new ShowWeightCommand(necklace));
        do{
            commands.get(100).execute();

            Scanner myObj = new Scanner(System.in);
            choice = myObj.nextInt();

            if(choice>0 && choice<=7)
                commands.get(choice).execute();

            System.out.println("\n");
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
