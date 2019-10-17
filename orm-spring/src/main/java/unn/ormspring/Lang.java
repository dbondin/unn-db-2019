package unn.ormspring;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "x_lang")
public class Lang {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lang_id")
	private Long id;
	
	@Column(name = "lang_name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "lang_descr", unique = false, nullable = true)
	private String descr;
	
	// Плохая связь. Дорогая очень.
	@OneToMany(mappedBy = "lang", fetch = FetchType.EAGER)
	private Set<Book> books = new HashSet<Book>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
