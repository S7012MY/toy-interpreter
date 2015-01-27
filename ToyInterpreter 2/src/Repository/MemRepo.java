package Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.ProgState;

public class MemRepo {
	ProgState ps;
	public MemRepo(ProgState ps) { this.ps=ps;}
	public void serializeToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("toyInterpreter.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(ps);

            out.close();
            fileOut.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: could not write: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
    public ProgState serializeFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("toyInterpreter.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ps = (ProgState) in.readObject();
            in.close();
            fileIn.close();
            return ps;
        }
        catch (IOException e)
        {
            System.out.println("ERROR: could not read: " + e.getMessage());
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ERROR: could not find class: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
