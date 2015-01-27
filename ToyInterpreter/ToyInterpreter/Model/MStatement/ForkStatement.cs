using System;

namespace ToyInterpreter.Model.MStatement
{
	[Serializable()]
	public class ForkStatement : Statement
	{
		private Statement s;

		public ForkStatement ()
		{
		}
		public ForkStatement (Statement ss)
		{
			s = ss;
		}

		public override String toString() {
			return "Fork(" + s.toString () + ")";
		}
		public Statement getS() {
			return s;
		}


		public void setS(Statement s) {
			this.s = s;
		}
	}
}

