using System;

namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public class ReadExpression : Expression
	{
		public override int eval(IDictionary vt,IHeap hp) {
			int c = Convert.ToInt32(Console.ReadLine());
			return c;
		}
		public ReadExpression ()
		{
		}
		public override String toString() {
			return "read()";
		}
	}
}

