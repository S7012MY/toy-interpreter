package Model.Statement;

public class ForkStatement extends Statement {

	private Statement s;
	
	
	@Override
	public String toString() {
		return "Fork("+s.toString()+")";
	}


	public Statement getS() {
		return s;
	}


	public void setS(Statement s) {
		this.s = s;
	}
	public ForkStatement(Statement s1) {
		this.s = s1;
	}


	public ForkStatement() {
		// TODO Auto-generated constructor stub
	}
}
