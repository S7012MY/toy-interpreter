package Model.Expression;

import Model.IDictionary;

public abstract class Expression implements java.io.Serializable{
	public abstract int eval(IDictionary id);
	public abstract String toString();
}
