import java.sql.*;

public class MusicDB {

    public MusicDB() {};

    public static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);

        return connection;
    }
}
