package Model.Expression;

import Model.IDictionary;

public class ArithExpression extends Expression {
	private Expression l,r;
	private char op;
	
	@Override
	public int eval(IDictionary id) {
		//System.out.println("arith");
		if(op == '+') return l.eval(id) + r.eval(id);
		else if(op == '-') return l.eval(id) - r.eval(id);
		else if(op == '*') return l.eval(id) * r.eval(id);
		else if(op == '/') return l.eval(id) / r.eval(id);
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
	}
	@Override
	public String toString() {
		return "("+ l.toString() + ")" + op + "(" + r.toString() + ")"; 
	}

}
