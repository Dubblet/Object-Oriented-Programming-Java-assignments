import java.util.List;

public class Artist {
    private String name;
    private int artistID;
    private List<Album> albums;

    public Artist() {
    }

    public Artist(String name, int artistID, List<Album> albums) {
        this.name = name;
        this.artistID = artistID;
        this.albums = albums;
    }

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

    public void printArtists() {
        System.out.println(getName());
    }

    public void printAlbumAndArtist() {
        System.out.println(getName());
        for (Album album : albums) {
            if (album.getArtistID() == getArtistID()) {
                System.out.println("\t" + album.getName());
            }
        }
    }
}
