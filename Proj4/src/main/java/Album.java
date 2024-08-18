public class Album {
    private String name;
    private int artistID;
    private int albumID;

    public Album() {
    }

    public Album(String name, int artistID, int albumID) {
        this.name = name;
        this.artistID = artistID;
        this.albumID = albumID;
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

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public void printAlbums() {
        System.out.println(getName());
    }
}
