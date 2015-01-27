using System;

namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public class NewExpression : Expression
	{
		private Expression e;
		public NewExpression ()
		{
		}
		public NewExpression (Expression ex)
		{
			e = ex;
		}
		public override int eval(IDictionary id,IHeap hp) {
			return hp.setv (e.eval (id,hp));
		}
		public override String toString() {
			return "new(" + e.toString () + ")";
		}
	}
}

