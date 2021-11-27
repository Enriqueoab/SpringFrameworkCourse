package keep.learning.step0.repositories;

import keep.learning.step0.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
