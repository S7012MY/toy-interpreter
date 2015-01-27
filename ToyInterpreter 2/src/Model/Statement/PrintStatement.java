package Model.Statement;

import Model.Expression.Expression;

public class PrintStatement extends Statement {
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
	@Override
	public String toString() {
		return "print(" + e.toString() + ")";
	}
}
