using System;
namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public class VarExpression : Expression {
		private string vname;

		public override int eval(IDictionary id,IHeap hp) {
			return id.get(vname);
		}
		public string getVname() {
			return vname;
		}
		public void setVname(string vname) {
			this.vname = vname;
		}
		public VarExpression(string vname) {
			this.vname=vname;
		}

		public override String toString() {
			return vname;
		}
	}
}

