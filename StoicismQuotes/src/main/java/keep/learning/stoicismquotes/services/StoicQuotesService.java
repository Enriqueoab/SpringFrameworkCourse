package keep.learning.stoicismquotes.services;

public interface StoicQuotesService {

    String getApiData();
    boolean convertDataToArray(String apiData);
    boolean checkApiCallResponseCode();
}
