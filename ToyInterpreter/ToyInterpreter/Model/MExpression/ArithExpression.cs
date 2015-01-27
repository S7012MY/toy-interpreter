using System;

namespace ToyInterpreter.Model.MExpression
{
	[Serializable()]
	public class ArithExpression : Expression {
		private Expression l,r;
		private char op;


		public override int eval(IDictionary id,IHeap hp) {
			//System.out.println("arith");
			if(op == '+') return l.eval(id,hp) + r.eval(id,hp);
			else if(op == '-') return l.eval(id,hp) - r.eval(id,hp);
			else if(op == '*') return l.eval(id,hp) * r.eval(id,hp);
			else if(op == '/') return l.eval(id,hp) / r.eval(id,hp);
			return 0;
		}
		public char getOp() {
			return op;
		}
		public void setOp(char op) {
			this.op = op;
		}
		public Expression getL() {
			return l;
		}
		public void setL(Expression l) {
			this.l = l;
		}
		public Expression getR() {
			return r;
		}
		public void setR(Expression r) {
			this.r = r;
		}

		public ArithExpression(Expression l, Expression r, char op) {
			this.l=l;
			this.r=r;
			this.op=op;
		}
		public ArithExpression() {
			// TODO Auto-generated constructor stub
		}
		public override String toString() {
			return "("+ l.toString() + ")" + op + "(" + r.toString() + ")"; 
		}
	}
}

