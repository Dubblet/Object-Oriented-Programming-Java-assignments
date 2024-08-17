import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proj4 {
    public static void main(String[] args) {
        Connection connection;
        try {
            connection = MusicDB.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM ARTISTS";

            ResultSet artists = statement.executeQuery(query);

            while(artists.next()) {
                System.out.println(artists.getString("name"));
            }
            artists.close();
        } catch (SQLException ex) {
            System.out.println("Error accessing database: " + ex.getMessage());
        }
    }
}
