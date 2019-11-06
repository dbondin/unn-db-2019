package unn.ormspring;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageService {

	private Logger logger = LoggerFactory.getLogger(StorageService.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Transactional(readOnly = true)
	public Lang getLangByName(final String name) {
		final TypedQuery<Lang> q = em.createQuery("from Lang where name=?1", Lang.class);
		q.setParameter(1, name);
		return q.getSingleResult();
	}
	
	@Transactional(readOnly = false)
	public Author addAuthor(String fn, String ln) {
		Author a = new Author();
		a.setFirstName(fn);
		a.setLastName(ln);
		em.persist(a);
		return a;
	}
	
	@Transactional(readOnly = false)
	public void addAuthorToBook(Long bookId, Author a)
	{
		Book b = em.find(Book.class, bookId);
		b.getAuthors().add(a);
		em.persist(b);
	}
	
	@Transactional(readOnly = false)
	public void xxx() {
		
//		Cat c1 = new Cat();
//		c1.setName("Васька");
//		c1.setDescr("c1");
//		em.persist(c1);
//		Cat c2 = new Cat();
//		c2.setName("Пушок");
//		c2.setDescr("c2");
//		em.persist(c2);
//		Cat c3 = new Cat();
//		c3.setName("Мурка");
//		c3.setDescr("c3");
//		em.persist(c3);
//		
//		Wolf w1 = new Wolf();
//		w1.setColor("Серый");
//		w1.setDescr("w1");
//		em.persist(w1);
//		Wolf w2 = new Wolf();
//		w2.setColor("Серый");
//		w2.setDescr("w1");
//		em.persist(w2);
		
//		em.createQuery("from Animal", Animal.class).getResultStream()
//		.forEach(c -> logger.info("{}", c));
		
		animalRepository.findAllByDescr("w1").forEach(c -> logger.info("{}", c));
	}
}
