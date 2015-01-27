package Model.Statement;

import Model.Expression.Expression;

public class LockExit extends Statement{
	private Expression e;
	
	public Expression getE() {
		return e;
	}

	public void setE(Expression e) {
		this.e = e;
	}
	
	@Override
	public String toString() {
		return "lockExit(" + e.toString() + ")";
	}
	public LockExit(Expression e) {
		this.e=e;
	}

	public LockExit() {
		// TODO Auto-generated constructor stub
	}
}
