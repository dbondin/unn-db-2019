package unn.ormspring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private StorageService storageService;
	
	@EventListener(ApplicationReadyEvent.class)
	//@Transactional(readOnly = false)
	public void doit() {
		logger.info("Start !!!");

//		Lang l = new Lang();
//		l.setName("Русский");
//		l.setDescr("Великий и могучий");
//		
//		em.persist(l);
//		
//		Lang l2 = new Lang();
//		l2.setName("English");
//		
//		em.persist(l2);
		
//		Lang l = em.find(Lang.class, 1L);
//		
//		Book b = new Book();
//		b.setTitle("Колобок");
//		b.setLang(l);
//		
//		em.persist(b);
		
//		Lang l = em.createQuery("from Lang where name='Русский'", Lang.class).getResultList().get(0);
//		
//		Book b = new Book();
//		b.setTitle("Снегурочка");
//		b.setLang(l);

//		em.persist(b);
		
//		Lang l = new Lang();
//		l.setName("Espanol");
//		l.setDescr("Do not speak your barbarial language");
//		em.persist(l);
//		
//		Book b = new Book();
//		b.setTitle("Don Kihot");
//		b.setLang(l);
//		em.persist(b);
		
//		List<Book> bl = em.createQuery("from Book", Book.class).getResultList();
//		
//		bl.forEach(b -> {
//			logger.info("book {} {}", b.getId(), b.getTitle());
//			logger.info("  lang class = {}", b.getLang().getClass());
//			logger.info("  lang {} {}", b.getLang().getId(), b.getLang().getName());
//		});
		
		Lang l = storageService.getLangByName("Русский");
		logger.info("Lang {} {} {}", l.getId(), l.getName(), l.getDescr());
		l.getBooks().forEach(b -> {
			logger.info("  {}", b.getTitle());
		});
	}

}
