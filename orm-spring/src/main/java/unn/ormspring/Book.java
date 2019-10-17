package unn.ormspring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "x_book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "book_id")
	private Long id;
	
	@Column(name = "book_title", unique = false, nullable = false, length = 256)
	private String title;
	
	@JoinColumn(name = "book_lang_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lang lang;
	

	@JoinTable(name = "x_book_author",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Author> authors = new HashSet<Author>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Lang getLang() {
		return lang;
	}
	
	public void setLang(Lang lang) {
		this.lang = lang;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
