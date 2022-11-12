package Commands;

import classes.Necklace;

import java.io.IOException;

public class SortCommand implements Command{
    Necklace necklace;
    public SortCommand(Necklace n) {
        necklace = n;
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        necklace.SortByPrice();
    }
}
