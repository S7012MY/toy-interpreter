package Model;

import mobserver.VarTableObserver;

public interface IDictionary {
	public int get(String n);
	public void set(String n,int v);
	public void printTable();
	public String toString();
	public void addObserver(VarTableObserver o);
	public IDictionary clone();
}
