package Model;


public class ProgState implements java.io.Serializable{
	public final IStack es;
	public final IOutBuffer ob;
	public final IDictionary vt;
	private final int psId;
	public final ILockTable lt;
	public ProgState(IStack es, IOutBuffer ob, IDictionary vt,int i, ILockTable lt) {
		this.es = es; this.ob = ob; this.vt = vt; this.psId=i; this.lt=lt;
	}
	public String toString() {
		return es.toString() + "\n" + ob.toString() + "\n" + vt.toString()+"\n"; 
	}
	public int getPsId() {
		return psId;
	}
}
