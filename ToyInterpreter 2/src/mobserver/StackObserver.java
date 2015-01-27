package mobserver;

import Model.IStack;

public class StackObserver extends CObserver implements java.io.Serializable{
	@Override
	public void onUpdate(Object o) {
		System.out.println("Exe stack:\n");
		System.out.println(o.toString());
	}
}
