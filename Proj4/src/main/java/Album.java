public class Album {
    // Fields
    private String name;
    private int artistID;
    private int albumID;

    /**
     * Constructor with all three params.
     * @param name The name of the album.
     * @param artistID ID # in the table of the artist linked to this album.
     * @param albumID ID # in the table, each album has a unique album ID.
     */
    public Album(String name, int artistID, int albumID) {
        this.name = name;
        this.artistID = artistID;
        this.albumID = albumID;
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

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    /**
     * Method to print out the album's name.
     */
    public void printAlbums() {
        System.out.println(getName());
    }
}
