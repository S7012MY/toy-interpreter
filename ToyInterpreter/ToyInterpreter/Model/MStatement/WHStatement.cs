using System;
using ToyInterpreter.Model.MExpression;

namespace ToyInterpreter.Model.MStatement
{
	[Serializable()]
	public class WHStatement : Statement
	{
		private String vn;
		private Expression vl;
		public WHStatement ()
		{
		}
		public WHStatement (String varname,Expression v)
		{
			vn = varname; vl = v;
		}
		public String getVN() {
			return vn;
		}
		public Expression getV() {
			return vl;
		}
		public override String toString() {
			return "WH(" + vn + ")=" + vl.toString();
		}
	}
}

