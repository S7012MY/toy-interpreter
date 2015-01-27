package Model;

import java.util.ArrayList;
import java.util.Observer;
import java.util.Stack;

import mobserver.CObserver;
import mobserver.StackObserver;
import Model.Statement.Statement;
/*
public class ExeStack implements IStack{
	private final Statement[] st;
	private int size;
	public ExeStack() {
		st=new Statement[Constants.stackSize];
	}
	public void push(Statement s) {
		st[size++] = s;
	}
	
	public Statement top() {
		return st[size-1];
	}
	
	public void pop() {
		--size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
}
*/

public class ExeStack implements IStack,java.io.Serializable {

	private final Stack<Statement> st = new Stack<Statement>();
	private final ArrayList<StackObserver> o = new ArrayList<StackObserver>();
	
	public void addObserver(StackObserver ob) {
		o.add(ob);
	}
	
	private void notifyObservers() {
		for(int i = 0; i < o.size(); ++i) 
			o.get(i).onUpdate(this);
	}
	
	@Override
	public void push(Statement s) {
		st.push(s);
		notifyObservers();
		
	}

	@Override
	public Statement top() {
		return st.peek();
	}

	@Override
	public void pop() {
		st.pop();
	}

	@Override
	public boolean isEmpty() {
		return st.isEmpty();
	}
	
	public String toString() {
		if(isEmpty()) return "Exe stack is empty!\n";
		String r="Exe stack:\n";
		for(Statement s : st) {
			r += "\t" + s.toString() +"\n";
		}
		return r;
	}
}