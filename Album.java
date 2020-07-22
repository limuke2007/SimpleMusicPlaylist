package Section8_Arrays_JavaInbuiltList_AutoUnbox.LinkedListChallenge_SongPlaylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

// fields

    private String albumName;
    private String artist;
    private ArrayList<Song> songs;

// constructor

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }


// methods

    public boolean addSong(String newTitle, double duration) {
        if (findSong(newTitle) == null) {
            songs.add(new Song(newTitle, duration));
            return true;
        }
        System.out.println("Song already exists.");
        return false;
    }

    private Song findSong(String title) {
//        for (int i = 0; i < songs.size(); i++) {
//            Song checkedSong = songs.get(i);
//            if (checkedSong.getTitle().equals(title)) {
//                return checkedSong;
//            }
//        }
        for (Song checkedSong : songs) {                        // enhanced "for-loop": (for each)
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0 ) && (index < songs.size())) {
            playlist.add(songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("the song " + title + " is not in this album.");
        return false;
    }
}
