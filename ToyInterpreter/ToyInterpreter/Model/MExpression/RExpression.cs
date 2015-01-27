using System;

namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public class RExpression : Expression
	{
		private Expression addr;
		public override int eval(IDictionary id,IHeap hp) {
			return hp.getv (addr.eval(id,hp));
		}
		public RExpression ()
		{
		}
		public RExpression (Expression a)
		{
			addr = a;
		}
		public override String toString() {
			return "r(" + addr.toString() + ")";
		}
	}
}

