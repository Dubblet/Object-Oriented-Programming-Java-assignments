public class Proj4 {
    public static void main(String[] args) {
        MusicDB musicDB = new MusicDB();

        System.out.println("Artists and Albums Listing");
        System.out.println("\nArtists\n-------");
        for (Artist artist : musicDB.artistslist()) {
            artist.printArtists();
        }
        System.out.println("\nAlbums\n------");
        for (Album album : musicDB.albumList()) {
            album.printAlbums();
        }
        System.out.println("\nAlbums by Artist\n----------------");
        for (Artist artist : musicDB.artistslist()) {
            artist.printAlbumAndArtist();
        }
    }
}
