package keep.learning.repaircarshop.repositories;

import keep.learning.repaircarshop.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
