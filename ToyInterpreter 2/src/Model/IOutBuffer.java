package Model;

import mobserver.OutBufferObserver;
import mobserver.VarTableObserver;

public interface IOutBuffer {
	public void add(String s);
	public int getSize();
	public void printBuffer();
	public String toString();
	public void addObserver(OutBufferObserver o);
}
