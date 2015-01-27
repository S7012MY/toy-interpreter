package Model.Statement;

public class CompoundStatement extends Statement {
	private Statement s1,s2;
	
	public CompoundStatement(Statement l,Statement r) {s1=l;s2=r;}

	public CompoundStatement() {
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

	@Override
	public String toString() {
		return s1.toString() + ";"+s2.toString();
	}
}
