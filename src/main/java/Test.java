
import com.google.gson.Gson;
import dao.ResponseDaoHibernate;
import dao.ResponseDaoInterface;
import model.ResponseFromServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IResponseService;
import service.ResponseService;
import utils.GetURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Created by vitaliy on 24.10.15.
 */
public class Test {


    public static void main(String[] args) throws IOException {
        HttpURLConnection connection= GetURLConnection.getConnection();
        String input="{\"key\":\"$1$12309856$euBrWcjT767K2sP9MHcVS/\",\"echo\":\"test123\"}";
        OutputStream outputStream=connection.getOutputStream();
        outputStream.write(input.getBytes());
        outputStream.flush();
        StringBuilder stringBuilder=GetStringFromServer.getString(connection);
        ResponseFromServer response=new Gson().fromJson(stringBuilder.toString(), ResponseFromServer.class);


        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        IResponseService responseService= (IResponseService) applicationContext.getBean("ResponseService");
        responseService.addData(response);
        connection.disconnect();

    }

}
