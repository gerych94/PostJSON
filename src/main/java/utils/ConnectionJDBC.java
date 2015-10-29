package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vitaliy on 26.10.15.
 */
public class ConnectionJDBC {

    private static final String URL="jdbc:mysql://localhost:3306/jsontask";
    private static final String USER="root";
    private static final String PASSWORD="root";


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
