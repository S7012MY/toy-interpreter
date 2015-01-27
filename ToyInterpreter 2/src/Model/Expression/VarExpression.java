package Model.Expression;

import Model.IDictionary;

public class VarExpression extends Expression {
	private String vname;
	@Override
	public int eval(IDictionary id) {
		return id.get(vname);
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public VarExpression(String vname) {
		this.vname=vname;
	}
	@Override
	public String toString() {
		return vname;
	}
}
