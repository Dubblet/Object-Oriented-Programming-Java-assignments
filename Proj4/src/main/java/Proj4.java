public class Proj4 {
    public static void main(String[] args) {
        MusicDB musicDB = new MusicDB();

        System.out.println("Artists and Albums Listing");
        System.out.println("\nArtists\n-------");
        // Call the method to get a list of artists, loop through each artist and print out their name.
        for (Artist artist : musicDB.artistslist()) {
            artist.printArtists();
        }
        System.out.println("\nAlbums\n------");
        // Call the method to get a list of albums, loop through each one and print out the album name.
        for (Album album : musicDB.albumList()) {
            album.printAlbums();
        }
        System.out.println("\nAlbums by Artist\n----------------");
        // Loop through each artist, this time printing out both their name and all albums linked to them.
        for (Artist artist : musicDB.artistslist()) {
            artist.printAlbumAndArtist();
        }
    }
}
