using System;

namespace ToyInterpreter.Model
{
	public interface IHeap
	{
		int getv(int addr);
		int setv(int vl);
		void mod(int addr,int vl);
		String toString();
	}
}

