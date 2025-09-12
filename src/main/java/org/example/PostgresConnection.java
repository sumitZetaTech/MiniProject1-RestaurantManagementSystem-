import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/restaurantmanager"; // Change DB name if needed
        String user = "sumitnegi";  // Replace with your actual username
        String password = "";       // Add password if set, otherwise leave empty

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
