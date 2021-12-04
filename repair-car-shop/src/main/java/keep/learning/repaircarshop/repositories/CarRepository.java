package keep.learning.repaircarshop.repositories;

import keep.learning.repaircarshop.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
