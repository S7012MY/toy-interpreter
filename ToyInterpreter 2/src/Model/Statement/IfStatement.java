package Model.Statement;

import Model.Expression.Expression;

public class IfStatement extends Statement {
	private Expression e;
	private Statement s1,s2;
	public IfStatement(Expression e,Statement s1,Statement s2) {
		this.e=e;
		this.s1=s1;
		this.s2=s2;
	}
	public IfStatement() {
		// TODO Auto-generated constructor stub
	}
	public Statement getS2() {
		return s2;
	}
	public void setS2(Statement s2) {
		this.s2 = s2;
	}
	public Statement getS1() {
		return s1;
	}
	public void setS1(Statement s1) {
		this.s1 = s1;
	}
	public Expression getE() {
		return e;
	}
	public void setE(Expression e) {
		this.e = e;
	}
	@Override
	public String toString() {
		return "if("+e.toString()+")\t" + s1.toString() + "else\t" + s2.toString();
	}
}
