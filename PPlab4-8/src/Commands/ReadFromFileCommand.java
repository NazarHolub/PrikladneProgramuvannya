package Commands;

import classes.Necklace;
import classes.Stone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFromFileCommand implements Command{
    Necklace necklace;
    File file;
    public ReadFromFileCommand(Necklace n,File f) {
        necklace = n;
        file = f;
    }
    @Override
    public void execute() throws IOException, ClassNotFoundException{
        Object result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = ois.readObject();
        }
        necklace.SetNecklace((Necklace)result);
    }
}
