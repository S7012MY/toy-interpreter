package Model;

public class LockTable implements ILockTable, java.io.Serializable {

	private int[] lt = new int[3];
	
	@Override
	public int get(int p) throws ArrayIndexOutOfBoundsException{
		if(p>2) throw new ArrayIndexOutOfBoundsException("Index greater than 2");
		return lt[p];
	}

	@Override
	public void set(int p, int v) {
		lt[p]=v;
	}
	public String toString() {
		String r = "LockTable:\n";
		for(int i = 0; i < 3; ++i) r += "lt[" + i + "] = " + lt[i]+"\n";
		return r;
	}
}
