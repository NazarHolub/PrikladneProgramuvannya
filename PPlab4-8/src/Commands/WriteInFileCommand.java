package Commands;

import classes.Necklace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteInFileCommand implements Command{
    Necklace necklace;
    File file;
    public WriteInFileCommand(Necklace n,File f) {
        necklace = n;
        file = f;
    }
    @Override
    public void execute() {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(necklace);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
