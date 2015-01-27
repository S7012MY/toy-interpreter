package Model;

public class Pair {
	private String name;
	private int value;
	public Pair(String name, int value) {
		setName(name); setValue(value);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
