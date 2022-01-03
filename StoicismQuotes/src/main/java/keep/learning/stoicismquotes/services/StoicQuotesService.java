package keep.learning.stoicismquotes.services;

public interface StoicQuotesService {

    String findById(Long id);
    boolean checkId(int quoteId);
    boolean checkApiCallResponseCode();
}
