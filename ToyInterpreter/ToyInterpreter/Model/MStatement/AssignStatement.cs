using System;
using ToyInterpreter.Model.MExpression;

namespace ToyInterpreter.Model.MStatement
{
	[Serializable()]
	public class AssignStatement : Statement {
		private string var;
		private Expression e;
		public AssignStatement(string var,Expression e) {
			this.var=var; this.e=e;
		}
		public AssignStatement() {
			// TODO Auto-generated constructor stub
		}
		public string getVar() {
			return var;
		}
		public void setVar(string var) {
			this.var = var;
		}
		public Expression getE() {
			return e;
		}
		public void setE(Expression e) {
			this.e = e;
		}
		public override String toString() {
			return var + "=" + e.toString();
		}
	}
}

