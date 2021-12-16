package keep.learning.carshop.repositories;

import keep.learning.carshop.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
