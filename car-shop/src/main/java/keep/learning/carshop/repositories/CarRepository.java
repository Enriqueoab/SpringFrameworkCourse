package keep.learning.carshop.repositories;

import keep.learning.carshop.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
