package keep.learning.stoicismquotes;

import keep.learning.stoicismquotes.services.StoicQuotesServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StoicismQuotesApplication {

    private static String apiUrl;

    public StoicismQuotesApplication(@Value("${api.url}") String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public static void main(String[] args) {
        SpringApplication.run(StoicismQuotesApplication.class, args);

        StoicQuotesServiceImpl s = new StoicQuotesServiceImpl(apiUrl);
        s.getQuote();
    }

}
