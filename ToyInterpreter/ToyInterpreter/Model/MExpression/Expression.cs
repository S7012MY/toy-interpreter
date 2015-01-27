using System;

namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public abstract class Expression {
		public abstract int eval(IDictionary id,IHeap hp);
		public abstract String toString();
	}
}

