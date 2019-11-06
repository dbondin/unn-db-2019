package unn.ormspring;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Wolf extends Animal {

	@Column
	private String color;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Wolf [color=" + color + ", id=" + id + "]";
	}
	
	
}
