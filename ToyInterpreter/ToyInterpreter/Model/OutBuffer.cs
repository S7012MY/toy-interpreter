using System;
using System.Collections.Generic;
using ToyInterpreter.Model.MObserver;

namespace ToyInterpreter.Model
{
	/*public class OutBuffer : IOutBuffer {
		private readonly string[] arr;
		private int size;
		public OutBuffer() {
			arr = new string[Constants.stackSize];
			setSize(0);
		}

		public void add(string s) {
			arr[getSize()] = s;
			setSize(getSize() + 1);
		}
		public int getSize() {
			return size;
		}
		public void printBuffer() {
			for(int i=0; i<getSize(); ++i) Console.WriteLine(arr[i]);
		}
		private void setSize(int size) {
			this.size = size;
		}
	}*/
	[Serializable()]
	public class OutBuffer : IOutBuffer {
		private readonly List<string> arr;
		private readonly List<CObserver> o;

		public OutBuffer() {
			arr = new List<string>();
			o = new List<CObserver>();
		}

		public void addObserver(OutBufferObserver ob) {
			o.Add(ob);
		}

		private void notifyObservers() {
			for(int i = 0; i < o.Count; ++i) o[i].onUpdate(this);
		}

		public void add(string s) {
			arr.Add (s);
			notifyObservers ();
		}
		
		public int getSize() {
			return arr.Count;
		}
		public void printBuffer() {
			for(int i=0; i<getSize(); ++i) Console.WriteLine(arr[i]);
		}
		public String toString() {
			if(getSize()==0) return "OutBuffer is empty!\n";
			String r="OutBuffer:\n";
			foreach(String s in arr) 
				r+=s+"\n";
			return r;
		}
	}
}

