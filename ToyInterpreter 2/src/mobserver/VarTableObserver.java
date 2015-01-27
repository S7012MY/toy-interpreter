package mobserver;

import Model.IDictionary;

public class VarTableObserver extends CObserver implements java.io.Serializable{
	@Override
	public void onUpdate(Object o) {
		System.out.println("Var table:\n");
		System.out.println(o.toString());
	}
}
