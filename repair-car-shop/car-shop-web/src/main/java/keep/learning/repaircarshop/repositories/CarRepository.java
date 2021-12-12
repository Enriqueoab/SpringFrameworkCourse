package keep.learning.repaircarshop.repositories;

import keep.learning.repaircarshop.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
