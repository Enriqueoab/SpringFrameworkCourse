package keep.learning.stoicismquotes;

import keep.learning.stoicismquotes.services.StoicQuotesServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoicismQuotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoicismQuotesApplication.class, args);
        StoicQuotesServiceImpl s = new StoicQuotesServiceImpl();
        s.findById(1L);
    }

}
