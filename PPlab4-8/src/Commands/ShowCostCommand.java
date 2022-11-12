package Commands;

import classes.Necklace;

import java.io.IOException;

public class ShowCostCommand implements Command{
    Necklace necklace;
    public ShowCostCommand(Necklace n) {
        necklace = n;
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.println(necklace.Cost());
    }
}
