import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDB {

    public MusicDB() {};

    public static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);

        return connection;
    }

    public ArrayList<Album> albumList() {
        Connection connection;
        ArrayList<Album> albumList = new ArrayList<Album>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String query = """
                    SELECT * FROM albums
                    ORDER BY name ASC""";

            ResultSet albums = statement.executeQuery(query);

            while (albums.next()) {
                String albumName = albums.getString("name");
                int albumId = albums.getInt("albumId");
                int artistId = albums.getInt("artistId");
                Album album = new Album(albumName, artistId, albumId);
                albumList.add(album);
            }

            albums.close();
        } catch (SQLException ex) {
            System.out.println("Error accessing database: " + ex.getMessage());
        }
        return albumList;
    }

    public ArrayList<Artist> artistslist() {
        Connection connection;
        ArrayList<Artist> artistList = new ArrayList<Artist>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String query = """
                    SELECT * FROM artists
                    ORDER BY name ASC""";

            ResultSet artists = statement.executeQuery(query);

            while (artists.next()) {
                String artistName = artists.getString("name");
                int artistId = artists.getInt("artistId");
                List<Album> albums = new ArrayList<>();
                for (Album album : albumList()) {
                    if (album.getArtistID() == artistId) {
                        albums.add(album);
                    }
                }
                Artist artist = new Artist(artistName, artistId, albums);
                artistList.add(artist);
            }

            artists.close();
        } catch (SQLException ex) {
            System.out.println("Error accessing database: " + ex.getMessage());
        }
        return artistList;
    }
}
