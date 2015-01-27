package Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.ExeStack;
import Model.IDictionary;
import Model.IOutBuffer;
import Model.LockTable;
import Model.OutBuffer;
import Model.ProgState;
import Model.VarTable;
import Model.Statement.Statement;

public class Repo implements IRepo,java.io.Serializable {
	private int numProg;
	private ProgState pslist[] = new ProgState[100];
	public OutBuffer ob;
	public LockTable lt;
	private int cid = 1;
	
	public void removePs(int i) {
		ob = (OutBuffer) pslist[1].ob;
		for(;i<numProg; ++i) pslist[i]=pslist[i+1];
		--numProg;
	}
	public ProgState getPS(int i) {return pslist[i];}
	public void addPs(IOutBuffer ob, IDictionary vt, Statement st) {
		++numProg;
		pslist[numProg] = new ProgState(new ExeStack(), ob, vt.clone(),cid,lt);
		pslist[numProg].es.push(st);
		++cid;
	}
	
	public String toString() {
		String s="";
		s+="Number of programs: " + numProg+"\n";
		for(int i=1; i <= numProg; ++i) {
			s+="Program "+i+ "\n";
			s+=pslist[i].es.toString();
			s+=pslist[i].ob.toString();
			s+=pslist[i].vt.toString();
			s+=pslist[i].lt.toString();
		}
		return s;
	}
	
	public Repo() {
		numProg = 1;
		ob = new OutBuffer(); lt = new LockTable();
		pslist[numProg] = new ProgState(new ExeStack(),ob,new VarTable(),cid,lt);
		++cid;
	}
	
	public int getNumProg() {
		return numProg;
	}
	public void serializeToFile() {
		 try {
	            FileOutputStream fileOut = new FileOutputStream("toyInterpreter.txt");
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);

	            out.writeObject(this);

	            out.close();
	            fileOut.close();
	        }
	        catch (IOException e) {
	            System.out.println("ERROR: could not write: " + e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	public Repo serializeFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("toyInterpreter.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Repo ps = (Repo) in.readObject();
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
