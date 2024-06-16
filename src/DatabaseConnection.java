import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/bankapplication";
    private static final String user = "root";
    private static final String pass = "800800";

         public static Connection getConnection() throws SQLException {

                 return DriverManager.getConnection(url, user, pass);
             }

     }

