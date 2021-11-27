package keep.learning.step0.bootstrap;

import keep.learning.step0.repositories.AuthorRepository;
import keep.learning.step0.repositories.BookRepository;
import keep.learning.step0.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//It tells the Spring Framework to go ahead and detect this as
//a Spring managed component
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private  final PublisherRepository publisherRepository;

    //Through dependency injection into the constructor is going to bring both repositories instances
    // into the Spring context
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
