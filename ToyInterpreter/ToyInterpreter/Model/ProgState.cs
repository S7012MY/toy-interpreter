using System;

namespace ToyInterpreter.Model
{
	[Serializable()]
	public class ProgState
	{
		public readonly IStack es;
		public readonly IOutBuffer ob;
		public readonly IDictionary vt;
		public readonly int psId;
		public readonly IHeap hp;
		public ProgState(IStack es,IOutBuffer ob,IDictionary vt,int i,IHeap hp) {
			this.es = es;
			this.ob = ob;
			this.vt = vt;
			this.hp = hp;
			psId = i;
		}
		public String toString() {
			return es.toString() + "\n" + ob.toString() + "\n" +vt.toString()+"\n"; 
		}
	}
}

