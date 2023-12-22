import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @Test
    void testAddSongToAlbum() {
        Album album = new Album("Stormbringer", "Deep Purple");
        assertTrue(album.addSong("Stormbringer", 4.6));
        assertTrue(album.addSong("Love don't mean a thing", 4.22));
        assertFalse(album.addSong("Stormbringer", 4.6)); // Adding duplicate song should return false

    }

    @Test
    void testAddToPlayListByTrack() {
        Album album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);

        LinkedList<Song> playList = new LinkedList<>();
        assertTrue(album.addToPlayList(1, playList));
        assertTrue(album.addToPlayList(2, playList));
        assertFalse(album.addToPlayList(4, playList)); // Non-existing track should return false

        assertEquals(2, playList.size());
    }

    @Test
    void testAddToPlayListByTitle() {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Lady double dealer", 3.21);
        album.addSong("The gypsy", 4.2);

        LinkedList<Song> playList = new LinkedList<>();
        assertTrue(album.addToPlayList("Lady double dealer", playList));
        assertTrue(album.addToPlayList("The gypsy", playList));
        assertFalse(album.addToPlayList("Stormbringer", playList)); // Non-existing title should return false

        assertEquals(2, playList.size());
    }
}
