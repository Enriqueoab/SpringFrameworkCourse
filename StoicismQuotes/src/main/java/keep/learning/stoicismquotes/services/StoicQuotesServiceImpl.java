package keep.learning.stoicismquotes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
@Service
public class StoicQuotesServiceImpl implements StoicQuotesService {

    private HttpURLConnection conn;
    private  URL url;
    private Map<String, String> apiDataMap;

    //Fix it? - The function checkApiCallResponseCode
    //is not able to get its value
    @Value("${api-url}")
    private String apiEndpoint;

    public String getApiEndpoint() {
        return apiEndpoint;
    }


    @Override
    public String getQuote() {

        String quoteInfo = getQuotesById(3); //TODO: Fix the hard code value
        String rexId = "id";
        String rexAuthor = "author";
        String rexQuote = "quote";

        Pattern pattern = Pattern.compile(rexId);
        Matcher matcher = pattern.matcher(quoteInfo);
        boolean matchFound = matcher.find();
        System.out.println(matchFound);

        return "quotes/see_quote"; //TODO: Set this package and template in resources/template

    }


    @Override
    public String getQuotesById(int quoteId) {

        String apiData = "";

        if (checkConnection()){
            try {
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
                    System.out.println("Data from API (getQuotesById): "+ apiData);
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
