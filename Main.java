package Section8_Arrays_JavaInbuiltList_AutoUnbox.LinkedListChallenge_SongPlaylist;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {


        Album album1 = new Album("Thriller", "Micheal Jackson");

        album1.addSong("The Girl Is Mine", 3.50);
        album1.addSong("Billie Jean", 3.40);
        album1.addSong("Beat It", 4.50);
        album1.addSong("Wanna Be Startin' Somethin'", 3.55);
        album1.addSong("Human Nature", 3.30);
        album1.addSong("P.Y.T. (Pretty Young Thing)", 3.40);
        album1.addSong("Thriller", 5.20);

        albums.add(album1);

        album1 = new Album("Bad", "MJ");

        album1.addSong("I Just Can't Stop Loving You", 4.05);
        album1.addSong("Bad", 3.57);
        album1.addSong("The Way You Make Me Feel", 4.16);
        album1.addSong("Man in the Mirror", 3.42);
        album1.addSong("Dirty Diana", 4.20);
        album1.addSong("Another Part of Me", 3.27);
        album1.addSong("Smooth Criminal", 4.16);
        album1.addSong("Leave Me Alone", 3.55);
        album1.addSong("Liberian Girl", 5.10);

        album1.addSong("Bad", 3.00);                            // already exist

        albums.add(album1);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Billie Jean", playlist);
        albums.get(1).addToPlaylist("Dirty Diana", playlist);
        System.out.println(playlist);


        albums.get(0).addToPlaylist("Dangerous", playlist);     // not in this album


        albums.get(1).addToPlaylist("Liberian Girl", playlist);
        System.out.println(playlist);

        albums.get(0).addToPlaylist(1,playlist);
        albums.get(0).addToPlaylist(3,playlist);
        albums.get(0).addToPlaylist(8,playlist); // This album does not have a track 8
        albums.get(1).addToPlaylist(4, playlist);
        albums.get(1).addToPlaylist(7, playlist);
        System.out.println(playlist);


        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> it = playlist.listIterator();    // we need to go both next and previous: ListIterator

        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            System.out.println("Now playing " + it.next());  // it.next().toString() 默认可省略
            printMenu();
        }


        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();     // handle Enter key issue
            switch (action) {
                case 0:     // stop
                    System.out.println("Stopping the playlist.");
                    quit = true;
                    break;

                case 1: // play next

                    if (!goingForward) {
                        if (it.hasNext()) {
                            it.next();      // change direction
                        }
                        goingForward = true;
                    }

                    if (it.hasNext()) {
                        System.out.println("Now playing " + it.next());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;


                case 2: // play previous

                    if (goingForward) {
                        if (it.hasPrevious()) {
                            it.previous();      // change direction
                        }
                        goingForward = false;
                    }

                    if (it.hasPrevious()) {
                        System.out.println("Now playing " + it.previous());
                    } else {
                        System.out.println("This is the beginning of the playlist");
                        goingForward = true;
                    }
                    break;

                case 3: // replay

                    if(goingForward) {
                        if (it.hasPrevious()) {
                            System.out.println("Replaying " + it.previous());
                            goingForward = false;
                        } else {
                            System.out.println("We are at the beginning of the list.");
                        }
                    } else {
                        if (it.hasNext()) {
                            System.out.println("Replaying " + it.next());
                            goingForward = true;
                        } else {
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;

                case 4: // list the song in the playlist
                    listSongs(playlist);
                    break;
                    
                case 5:
                    if (playlist.size() > 0) {
                        it.remove();                                            // when a song is removed,
                        if (it.hasNext()) {                                     // automatically play the next song
                            System.out.println("Now playing " + it.next());
                        } else if (it.hasPrevious()) {                              // when at the end of list
                            System.out.println("Now playing " + it.previous());     // play the previous song
                        }
                    }
                    break;
                    
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    private static void listSongs( LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();              // we only need to go forward: Iterator
        System.out.println("======================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======================");

//        for (int i =0; i< playlist.size(); i++) {
//            Song checkedSong = playlist.get(i);
//            System.out.println( (i+1) + " ." + checkedSong.getTitle());
//        }
    }

    private static void printMenu() {
        System.out.println("Available options:\npress ");

        System.out.println("0 - to stop\n" +
                "1 - to play next song\n" +
                "2 - to play the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list the songs in the playlist\n" +
                "5 - to remove a song from the playlist\n" +
                "6 - to print menu");
    }


}
