package userlogin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseInitializer {

    private  static  String  url="jdbc:postgresql://localhost:5432/assignment1";
   private static  Connection conn  ;


    public  static  Connection getconnection( ) {
        try {
            conn = DriverManager.getConnection(url , "postgres" , "postgres");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return conn ;

    }
}
