import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection;

    public static Connection createDBConnection() {
        String url = "jdbc:mysql://localhost:3306/Data";
        String username = "root";
        String password = "airiqbalRseeam99*";

        try {
            //System.out.println("Trying to connect to MySQL database..........");
            connection = DriverManager.getConnection(url, username, password);
            //System.out.println("Successfully connected ! ");
        } catch (SQLException e) {
            System.err.println("Failed to connect to MySQL database ! ");
            System.err.println("Error shown below: ");
            e.printStackTrace();
        }

        return connection;
    }
}
