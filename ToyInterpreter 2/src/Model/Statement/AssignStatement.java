package Model.Statement;

import Model.Expression.Expression;

public class AssignStatement extends Statement {
	private String var;
	private Expression e;
	public AssignStatement(String var,Expression e) {
		this.var=var; this.e=e;
	}
	public AssignStatement() {
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public Expression getE() {
		return e;
	}
	public void setE(Expression e) {
		this.e = e;
	}
	@Override
	public String toString() {
		return var + "=" + e.toString();
	}
}
