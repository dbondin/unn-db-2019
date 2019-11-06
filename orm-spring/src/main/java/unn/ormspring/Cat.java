package unn.ormspring;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

	@Column
	private String name;
	
	@Column
	private Integer age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", id=" + id + ", descr=" + descr + "]";
	}	
}
