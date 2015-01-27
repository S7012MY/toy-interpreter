package Model;

import java.util.ArrayList;

import mobserver.OutBufferObserver;
import mobserver.StackObserver;

/*public class OutBuffer implements IOutBuffer {
	private final String[] arr;
	private int size;
	public OutBuffer() {
		arr = new String[Constants.stackSize];
		setSize(0);
	}
	
	public void add(String s) {
		arr[getSize()] = s;
		setSize(getSize() + 1);
	}
	public int getSize() {
		return size;
	}
	public void printBuffer() {
		for(int i=0; i<getSize(); ++i) System.out.println(arr[i]);
	}
	private void setSize(int size) {
		this.size = size;
	}
}*/
public class OutBuffer implements IOutBuffer,java.io.Serializable {
	private final ArrayList<String> arr;
	
	private final ArrayList<OutBufferObserver> o = new ArrayList<OutBufferObserver>();
	
	public void addObserver(OutBufferObserver ob) {
		o.add(ob);
	}
	
	private void notifyObservers() {
		for(int i = 0; i < o.size(); ++i) 
			o.get(i).onUpdate(this);
	}
	
	public OutBuffer() {
		arr = new ArrayList<String>();
	}
	
	public void add(String s) {
		arr.add(s);
		notifyObservers();
	}
	public int getSize() {
		return arr.size();
	}
	public void printBuffer() {
		for(int i=0; i<arr.size(); ++i) System.out.println(arr.get(i));
	}
	public String toString() {
		if(getSize()==0) return "OutBuffer is empty!\n";
		String r="OutBuffer:\n";
		for(String s : arr) 
			r+=s+"\n";
		return r;
	}
}