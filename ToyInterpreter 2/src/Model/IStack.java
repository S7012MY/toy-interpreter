package Model;

import mobserver.StackObserver;
import mobserver.VarTableObserver;
import Model.Statement.Statement;

public interface IStack {
	public void push(Statement s);
	public Statement top();
	public void pop();
	public boolean isEmpty();
	public String toString();
	public void addObserver(StackObserver o);
}
