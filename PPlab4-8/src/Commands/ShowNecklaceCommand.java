package Commands;

import classes.Necklace;

import java.io.IOException;

public class ShowNecklaceCommand implements Command{
    Necklace necklace;
    public ShowNecklaceCommand(Necklace n) {
        necklace = n;
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException{
        System.out.println(necklace.toString());
    }
}
