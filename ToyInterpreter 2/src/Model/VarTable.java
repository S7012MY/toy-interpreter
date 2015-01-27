package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import mobserver.StackObserver;
import mobserver.VarTableObserver;

public class VarTable implements IDictionary,java.io.Serializable{
	private HashMap<String, Integer> table;
	
	private final ArrayList<VarTableObserver> o = new ArrayList<VarTableObserver>();
	
	public void addObserver(VarTableObserver ob) {
		o.add(ob);
	}
	
	private void notifyObservers() {
		for(int i = 0; i < o.size(); ++i) 
			o.get(i).onUpdate(this);
	}
	
	public VarTable() {
		table = new HashMap<String, Integer>();
	}
	
	public int get(String n) {
		return table.get(n);
	}
	
	public void set(String n,int v) {
		table.put(n, v);
		notifyObservers();
		
	}
	
	public void printTable() {
		for (Map.Entry<String, Integer> entry : table.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}
	
	public VarTable clone() {
		VarTable v = new VarTable();
		for (Map.Entry<String, Integer> entry : table.entrySet())
			v.set(entry.getKey(), entry.getValue());
		return v;
	}
	
	public String toString() {
		if(table.size()==0) return "Var table is empty!\n";
		String r="Var Table:\n";
		for (Map.Entry<String, Integer> entry : table.entrySet())
			r+=entry.getKey()+"="+entry.getValue()+"\n";
		return r;
	}
}
