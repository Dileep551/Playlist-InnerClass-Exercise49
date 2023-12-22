import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {

        if (songs.findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;

    }

    public boolean addToPlayList(int track, LinkedList<Song> playList) {

        Song checkSong = songs.findSong(track);
        int index = track - 1;
        if (checkSong != null) {
            playList.add(checkSong);
            return true;
        }
        System.out.println("This Album does not have track " + track);
        return false;
    }


    public boolean addToPlayList(String title, LinkedList<Song> playList) {

        Song checkedSong = songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This Song " + title + " is not in album");
        return false;
    }


    public static class SongList {

        private ArrayList<Song> songs;

        private SongList() {

            songs = new ArrayList<Song>();

        }

        private boolean add(Song song) {

            if (songs.contains(song)) {
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String titleOfSong) {

            for (Song s : songs) {

                if (s.getTitle().equals(titleOfSong)) {
                    return s;
                }

            }
            return null;
        }

        private Song findSong(int trackNumber) {

            int index = trackNumber - 1;
            if ((index >= 0) && (index < songs.size())) {
                return songs.get(index);
            }

            return null;

        }
    }


}

