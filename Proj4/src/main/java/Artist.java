import java.util.List;

public class Artist {
    // Fields
    private String name;
    private int artistID;
    private List<Album> albums;

    /**
     * Constructor with all three params.
     * @param name The name of the artist.
     * @param artistID Artist's ID # in the table to link it to their albums.
     * @param albums A list of albums linked to the artist.
     */
    public Artist(String name, int artistID, List<Album> albums) {
        this.name = name;
        this.artistID = artistID;
        this.albums = albums;
    }

    // Getters and Setters for each field.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    /**
     * Method to print out the artist's name.
     */
    public void printArtists() {
        System.out.println(getName());
    }

    /**
     * Method to print out the artist's name, and loop through the list of albums, printing out their names.
     */
    public void printAlbumAndArtist() {
        System.out.println(getName());
        for (Album album : albums) {
            System.out.println("\t" + album.getName());
        }
    }
}
