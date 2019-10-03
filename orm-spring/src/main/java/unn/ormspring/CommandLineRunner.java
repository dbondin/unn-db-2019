package unn.ormspring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
	
	@Autowired
	private EntityManager em;
	
	@PostConstruct
	public void doit() {
		logger.info("Start !!!");
		logger.info("em = {}", em);
		
		List<X> l = em.createQuery("from X").getResultList();
		
		l.forEach(x -> System.out.println(x));
		
// FIXME !!!
//		EntityTransaction t = em.getTransaction();
//		X x = em.find(X.class, 10009);
//		x.setValue1("HOHOHO");
//		em.persist(x);
//		t.commit();
//		logger.info("x = {}", x);
	}
	
}
