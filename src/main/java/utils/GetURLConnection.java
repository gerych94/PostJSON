package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vitaliy on 26.10.15.
 */
public class GetURLConnection {

    private static final String HTTP ="http://tripcomposer.net/rest/test/countries/get";

    public static HttpURLConnection getConnection() throws IOException {
        URL url= new URL(HTTP);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
      return connection;
    }

}
