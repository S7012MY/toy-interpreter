package mobserver;

import Model.IOutBuffer;

public class OutBufferObserver extends CObserver implements java.io.Serializable {
	@Override
	public void onUpdate(Object o) {
		System.out.println("Out Buffer:\n");
		System.out.println(o.toString());
	}
}
