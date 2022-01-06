package keep.learning.stoicismquotes.services;

import java.util.Map;

public interface StoicQuotesService {

    Map<String, String> getQuote();
    String getQuotesById(int quoteId);
}
