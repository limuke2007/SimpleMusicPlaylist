package Section8_Arrays_JavaInbuiltList_AutoUnbox.LinkedListChallenge_SongPlaylist;

public class Song {

// fields

    private String title;
    private double duration;

// constructor

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

// methods

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }

//        @Override
//    public String toString() {
//        return "Song{" +
//                "title='" + title + '\'' +
//                ", duration=" + duration +
//                '}';
//    }
}
