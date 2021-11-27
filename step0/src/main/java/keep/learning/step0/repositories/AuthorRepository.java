package keep.learning.step0.repositories;

import keep.learning.step0.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
