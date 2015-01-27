using System;
using System.Collections;
using System.Collections.Generic;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Model
{
	/*public class VarTable : IDictionary{
		private int size;
		private readonly Pair[] table = new Pair[Constants.stackSize];
		private void setSize(int size) {
			this.size = size;
		}

		public VarTable() {
			setSize(0);
			//table = new Pair[Constants.stackSize];
		}
		public int getSize() {
			return size;
		}

		public int get(string n) {
			for(int i = 0; i < getSize(); ++i) if(table[i].getName() == n)
				return table[i].getValue();
			return -1;
		}

		public void set(string n,int v) {
			for(int i = 0; i < getSize(); ++i) if(table[i].getName() == n) {
					table[i].setValue(v);
					return;
				}
			table[getSize()] = new Pair(n,v);
			setSize(getSize() + 1);
		}

		public void printTable() {
			for(int i = 0; i < getSize(); ++i)
				Console.WriteLine(table[i].getName() + " " + table[i].getValue());
		}
	}*/
	[Serializable()]
	public class VarTable : IDictionary{
		private readonly Dictionary<string, int> table;
		private readonly List<VarTableObserver> o;

		public VarTable() {
			table = new Dictionary<string, int> ();
			o = new List<VarTableObserver> ();
		}

		public void addObserver(VarTableObserver ob) {
			o.Add(ob);
		}

		private void notifyObservers() {
			for(int i = 0; i < o.Count; ++i) o[i].onUpdate(this);
		}

		public int get(string n) {
			return table [n];
		}

		public void set(string n,int v) {
			table [n] = v;
			notifyObservers ();
		}

		public void printTable() {
			foreach(KeyValuePair<string, int> entry in table)
				Console.WriteLine(entry.Key + " " + entry.Value);
		}

		public String toString() {
			if(table.Count==0) return "Var table is empty!\n";
			String r="Var Table:\n";
			foreach (KeyValuePair<string, int> entry in table)
				r+=entry.Key+"="+entry.Value+"\n";
			return r;
		}
		public IDictionary clone() {
			IDictionary v = new VarTable();
			foreach(KeyValuePair<string, int> entry in table)
				v.set(entry.Key, entry.Value);
			return v;
		}
	}
}

