using System;
using ToyInterpreter.Model.MExpression;

namespace ToyInterpreter.Model.MStatement
{
	[Serializable()]
	public class PrintStatement : Statement {
		private Expression e;
		public PrintStatement(Expression e) {
			this.e=e;
		}
		public PrintStatement() {
		}
		public Expression getE() {
			return e;
		}

		public void setE(Expression e) {
			this.e = e;
		}
		public override String toString() {
			return "print(" + e.toString() + ")";
		}
	}
}

