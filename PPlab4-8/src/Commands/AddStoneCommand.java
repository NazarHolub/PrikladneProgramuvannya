package Commands;

import classes.Necklace;
import classes.Stone;

import java.util.Scanner;

public class AddStoneCommand implements Command{
    Necklace necklace;
    public AddStoneCommand(Necklace n) {
        necklace = n;
    }
    @Override
    public void execute() {
        Scanner myObj = new Scanner(System.in);
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
    }
}
