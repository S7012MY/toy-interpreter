package Model.Expression;

import Model.IDictionary;

public class ConstExpression extends Expression {
	private int val;
	@Override
	public int eval(IDictionary id) {
		//System.out.println("const");
		return getVal();
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ConstExpression(int val) {
		this.val=val;
	}
	@Override
	public String toString() {
		return Integer.toString(val);
	}

}
