import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDB {

    // Constructor
    public MusicDB() {};

    /**
     * Method that makes a connection with the SQLite DB.
     * @return A connection to the tables in music_artists.sqlite.
     * @throws SQLException An exception indicating there was an error accessing the database.
     */
    public static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);

        return connection;
    }

    /**
     * Method that connects to the database and creates album objects to correspond to rows in the Albums table.
     * @return A list of album objects.
     */
    public ArrayList<Album> albumList() {
        // Get a connection and create a new list to be returned.
        Connection connection;
        ArrayList<Album> albumList = new ArrayList<Album>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            // Get everything from the albums table in alphabetical order.
            String query = """
                    SELECT * FROM albums
                    ORDER BY name ASC""";

            ResultSet albums = statement.executeQuery(query);

            // Make a new album object, and fill the fields with data from the table. Then add it to the list of albums.
            while (albums.next()) {
                String albumName = albums.getString("name");
                int albumId = albums.getInt("albumId");
                int artistId = albums.getInt("artistId");
                Album album = new Album(albumName, artistId, albumId);
                albumList.add(album);
            }

            albums.close();
            // Close the connection to the DB, or catch an error if it cannot connect to the database.
        } catch (SQLException ex) {
            System.out.println("Error accessing database: " + ex.getMessage());
        }
        return albumList;
    }

    /**
     * Method that connects to the database and creates artist objects to correspond to rows in the Artists table.
     * @return A list of artist objects.
     */
    public ArrayList<Artist> artistslist() {
        // Get a connection and create a new list to be returned.
        Connection connection;
        ArrayList<Artist> artistList = new ArrayList<Artist>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            // Get everything from the artists table in alphabetical order.
            String query = """
                    SELECT * FROM artists
                    ORDER BY name ASC""";

            ResultSet artists = statement.executeQuery(query);

            // Make a new artist object, and fill the fields with data from the table. Then add it to the list of artists.
            while (artists.next()) {
                String artistName = artists.getString("name");
                int artistId = artists.getInt("artistId");
                List<Album> albums = new ArrayList<>();
                // Call the album list method to get a list of all the albums. If they have the same artist ID as the
                // current artist, add that album to this artist object's list of album objects.
                for (Album album : albumList()) {
                    if (album.getArtistID() == artistId) {
                        albums.add(album);
                    }
                }
                Artist artist = new Artist(artistName, artistId, albums);
                artistList.add(artist);
            }

            artists.close();
            // Close the connection to the DB, or catch an error if it cannot connect to the database.
        } catch (SQLException ex) {
            System.out.println("Error accessing database: " + ex.getMessage());
        }
        return artistList;
    }
}
