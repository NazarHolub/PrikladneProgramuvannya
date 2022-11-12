package Commands;

import classes.Necklace;

import java.io.IOException;

public class ShowWeightCommand implements Command{
    Necklace necklace;
    public ShowWeightCommand(Necklace n) {
        necklace = n;
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.println(necklace.Weight());
    }
}
