using System;

namespace ToyInterpreter.Model
{
	public class Pair {
		private string name;
		private int value;
		public Pair(string name, int value) {
			setName(name); setValue(value);
		}
		public string getName() {
			return name;
		}
		public void setName(string name) {
			this.name = name;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
}

