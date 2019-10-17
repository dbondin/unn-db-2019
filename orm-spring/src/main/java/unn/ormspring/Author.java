package unn.ormspring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "x_author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "auth_id")
	private Long id;

	@Column(name = "auth_first_name", unique = false, nullable = false, length = 64)
	private String firstName;
	
	@Column(name = "auth_last_name", unique = false, nullable = false, length = 64)
	private String lastName;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
