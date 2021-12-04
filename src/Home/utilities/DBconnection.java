package Home.utilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection
{
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost/school system";
    private static String name="root";
    private static String password="";


    public static  Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);

       Connection con= DriverManager.getConnection(url,name,password);

        return con;
    }
}
