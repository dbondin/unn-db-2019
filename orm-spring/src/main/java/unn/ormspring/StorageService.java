package unn.ormspring;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public Lang getLangByName(final String name) {
		final TypedQuery<Lang> q = em.createQuery("from Lang where name=?1", Lang.class);
		q.setParameter(1, name);
		return q.getSingleResult();
	}
	
	//public void 
}
