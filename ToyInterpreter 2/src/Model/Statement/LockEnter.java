package Model.Statement;

import Model.Expression.Expression;

public class LockEnter extends Statement{
	private Expression e;
	
	public LockEnter(Expression e) {
		this.e=e;
	}
	
	public LockEnter() {
		// TODO Auto-generated constructor stub
	}

	public Expression getE() {
		return e;
	}

	public void setE(Expression e) {
		this.e = e;
	}
	
	@Override
	public String toString() {
		return "lockEnter(" + e.toString() + ")";
	}

}
