package keep.learning.stoicismquotes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
@Service
public class StoicQuotesServiceImpl implements StoicQuotesService {

    private HttpURLConnection conn;
    private  URL url;
    //Fix it? - The function checkApiCallResponseCode
    //is not able to get its value
    @Value("${api-url}")
    private String apiEndpoint;

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    @Override
    public String findById(Long id) {

        //Get a specific quote find by its ID

        if (checkApiCallResponseCode()){
            try {

                //Getting the response code
                int responseCode = conn.getResponseCode();

                if (responseCode != 200) {

                    throw new RuntimeException("findById, HttpResponseCode: " + responseCode);

                } else {

                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();

                    }
                    System.out.println("Data from JSON (findById): "+inline);

                    //Close the scanner
                    scanner.close();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    public boolean checkId(int quoteId) {

        //Check if the id of the quote that we are looking for
        //exist en the API

        return true;
    }

    @Override
    public boolean checkApiCallResponseCode() {

        int responseCode = 0;
        boolean confirmation = false;
        try {
                            //Fix it should take it from the class variable
                            //apiEndpoint
            url = new URL("https://stoic-quotes-app.herokuapp.com/quotes");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
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
