package unn.jdbctest;

public class X {
	private int id;
	private String value1;
	private int value2;

	
	
	public X(int id, String value1, int value2) {
		super();
		this.id = id;
		this.value1 = value1;
		this.value2 = value2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	@Override
	public String toString() {
		return "X [id=" + id + ", value1=" + value1 + ", value2=" + value2 + "]";
	}
	
	
}
