package unn.ormspring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class X {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String value1;
	
	@Column
	private Integer value2;
	
	public X() {
	}
	
	public X(Integer id, String value1, Integer value2) {
		super();
		this.id = id;
		this.value1 = value1;
		this.value2 = value2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public Integer getValue2() {
		return value2;
	}

	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

	@Override
	public String toString() {
		return "X [id=" + id + ", value1=" + value1 + ", value2=" + value2 + "]";
	}
	
	
}
