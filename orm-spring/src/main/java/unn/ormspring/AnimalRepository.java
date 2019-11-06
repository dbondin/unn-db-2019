package unn.ormspring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long>{
	Iterable<Animal> findAllByDescr(String descr);
}
