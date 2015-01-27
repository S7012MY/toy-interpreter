using System;

namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public class ConstExpression : Expression {
		private int val;

		public override int eval(IDictionary id,IHeap hp) {
			//System.out.println("const");
			return getVal();
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public ConstExpression(int val) {
			this.val=val;
		}
		public override String toString() {
			return val.ToString();
		}
	}
}

