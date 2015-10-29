import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by vitaliy on 26.10.15.
 */
public class GetStringFromServer {

    private static BufferedReader bufferedReader;


    public static StringBuilder getString(HttpURLConnection connection) throws IOException {
        bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String output;
        StringBuilder stringBuilder = new StringBuilder();
        while ((output=bufferedReader.readLine())!=null){
            stringBuilder.append(output);
            System.out.println(output);
        }
    return stringBuilder;
    }


}
