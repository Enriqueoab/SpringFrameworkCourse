package keep.learning.stoicismquotes.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
@Service
public class StoicQuotesServiceImpl implements StoicQuotesService, Serializable {

    private HttpURLConnection conn;
    private  URL url;
    private Map<String, String> apiDataMap;

    private String quoteInfo;

    //Fix it? - The function checkApiCallResponseCode
    //is not able to get its value
    @Value("${api-url}")
    private String apiEndpoint;

    @Override
    public Map<String, String> getQuote() {

        apiDataMap= null;
        ObjectMapper objectMapper = new ObjectMapper();

        quoteInfo = getQuotesById(7).substring(3); // VIP: We have to get rid of [] and keep {}, is the structure that the converter need TODO: Avoid the hard code value


        try {

            apiDataMap = objectMapper.readValue(quoteInfo, Map.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("Map id is: " + String.valueOf(apiDataMap.get("id")));
        System.out.println("Map author is: " + apiDataMap.get("author"));
        System.out.println("Map quote is: " + apiDataMap.get("quote"));

        return apiDataMap; //TODO: Set this package and template in resources/template

    }


    @Override
    public String getQuotesById(int quoteId) {

        String apiData = "";

        if (checkConnection()){
            try {
                url = new URL("https://stoic-quotes-app.herokuapp.com/quotes?id=" + quoteId);
                //Getting the response code
                int responseCode = conn.getResponseCode();
                if (responseCode != 200) {
                    throw new RuntimeException("getQuotesById error, HttpResponseCode: " + responseCode);
                } else {

                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        apiData += scanner.nextLine();
                    }
                    //Close the scanner
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
