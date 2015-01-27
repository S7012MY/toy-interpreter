using System;
using ToyInterpreter.Model.MStatement;
using System.Collections.Generic;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Model
{
	/*public class ExeStack : IStack{
		private readonly Statement[] st;
		private int size;
		public ExeStack() {
			st=new Statement[Constants.stackSize];
		}
		public void push(Statement s) {
			st[size++] = s;
		}

		public Statement top() {
			return st[size-1];
		}

		public void pop() {
			--size;
		}
		public bool isEmpty() {
			return size == 0;
		}
	}*/
	[Serializable()]
	public class ExeStack : IStack{
		private readonly Stack<Statement> st;
		private readonly List<StackObserver> o;

		public ExeStack() {
			st = new Stack<Statement>();
			o = new List<StackObserver> ();
		}

		private void notifyObservers() {
			for(int i = 0; i < o.Count; ++i) o[i].onUpdate(this);
		}

		public void addObserver(StackObserver ob) {
			o.Add(ob);
		}

		public void push(Statement s) {
			st.Push (s);
			notifyObservers ();
		}

		public Statement top() {

			return st.Peek ();
		}

		public void pop() {
			st.Pop ();
		}
		public bool isEmpty() {
			return st.Count == 0;
		}
		public String toString() {
			if(isEmpty()) return "Exe stack is empty!\n";
			String r="Exe stack:\n";
			foreach (Statement s in st) {
				r += "\t" + s.toString() +"\n";
			}
			return r;
		}
	}
}

