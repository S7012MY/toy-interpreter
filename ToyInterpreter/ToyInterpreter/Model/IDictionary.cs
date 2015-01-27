using System;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Model
{
	public interface IDictionary {
		int get(String n);
		void set(String n,int v);
		void printTable();
		void addObserver (VarTableObserver o);
		String toString();
		IDictionary clone();
	}
}

