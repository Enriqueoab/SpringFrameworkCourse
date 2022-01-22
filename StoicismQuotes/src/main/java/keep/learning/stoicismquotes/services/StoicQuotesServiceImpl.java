package keep.learning.stoicismquotes.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

@Configuration
@Service
public class StoicQuotesServiceImpl implements StoicQuotesService, Serializable {

    private HttpURLConnection conn;
    private  URL url;
    private Map<String, String> apiDataMap;
    private int quoteId = 0;
    private String quoteInfo;
    private String apiEndpoint;

    public StoicQuotesServiceImpl(@Value("${api.url}")String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    @Override
    public Map<String, String> getQuote() {

        apiDataMap= null;
        ObjectMapper objectMapper = new ObjectMapper();
        quoteId++;

            quoteInfo = getQuotesById(getQuoteId()).substring(3); // VIP: We have to get rid of [] and keep {}, is the structure that the converter need

        try {

            apiDataMap = objectMapper.readValue(quoteInfo, Map.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("Map id is: " + String.valueOf(apiDataMap.get("id")));
        System.out.println("Map author is: " + apiDataMap.get("author"));
        System.out.println("Map quote is: " + apiDataMap.get("quote"));
        setQuoteId(getQuoteId());
        return apiDataMap;

    }


    @Override
    public String getQuotesById(int quoteId) {

        String apiData = "";

        if (checkConnection()){
            try {
                url = new URL(apiEndpoint+ "?id=" + quoteId);

                //Getting the response code
                int responseCode = conn.getResponseCode();

                if (responseCode != 200) {
                    throw new RuntimeException("getQuotesById error, HttpResponseCode: " + responseCode);
                } else {
                    InputStream is = url.openStream();

                    Scanner scanner = new Scanner(is);

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {

                            apiData += scanner.nextLine();
                    }

                    scanner.close();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return apiData;
    }

    public boolean checkConnection(){

        int responseCode = 0;
        boolean confirmation = false;
        try {
            //Fix it should take it from the class variable
            //apiEndpoint
            url = new URL("https://stoic-quotes-app.herokuapp.com/quotes");
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            responseCode = conn.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in checkApiCallResponseCode(), Closing connection");
            conn.disconnect();
        }
        if (responseCode == 200){

            confirmation = true;
            System.out.println("Connection ready and working");
        }

        return confirmation;

    }

}
