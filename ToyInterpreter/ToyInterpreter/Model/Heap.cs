using System;

namespace ToyInterpreter.Model
{
	public class Heap : IHeap
	{
		private int fa = 0;
		private int[] hp = new int[100];
		public Heap ()
		{
		}
		public int getv(int addr) {return hp[addr];}
		public int setv(int vl) {
			hp [++fa] = vl;
			return fa;
		}
		public void mod(int addr,int vl) {
			hp [addr] = vl;
		}
		public String toString() {
			String r = "Heap:\n";
			for (int i = 1; i <= fa; ++i)
				r += "hp["+ i+"]=" + hp[i] + " ";
			return r;
		}

	}
}

