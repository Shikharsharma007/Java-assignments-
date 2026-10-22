
import java.util.*;

class Song {
    String id;
    String title;

    Song(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return title;
    }
}

public class MediaPlayerQueue {

    LinkedList<Song> playlist = new LinkedList<>();
    LinkedList<Song> recentHistory = new LinkedList<>();

    void addPrioritySong(Song song) {
        playlist.addFirst(song);
    }

    void addAtPosition(int index, Song song) {
        playlist.add(index, song);
    }

    void removeDuplicates() {
        HashSet<String> seen = new HashSet<>();
        ListIterator<Song> it = playlist.listIterator();

        while (it.hasNext()) {
            Song song = it.next();

            if (!seen.add(song.id)) {
                it.remove();
            }
        }
    }

    void recordPlayed(Song song) {
        recentHistory.addFirst(song);
    }

    void traverseForward() {
        ListIterator<Song> it = playlist.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    void traverseBackward() {
        ListIterator<Song> it =
            playlist.listIterator(playlist.size());

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    void showHistory() {
        System.out.println("Recently Played:");

        for (Song song : recentHistory) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MediaPlayerQueue player = new MediaPlayerQueue();

        Song s1 = new Song("1", "Song A");
        Song s2 = new Song("2", "Song B");
        Song s3 = new Song("1", "Song A Duplicate");

        player.addAtPosition(0, s1);
        player.addAtPosition(1, s2);
        player.addAtPosition(2, s3);

        player.addPrioritySong(new Song("3", "Priority Song"));

        player.removeDuplicates();

        System.out.println("Forward Playlist:");
        player.traverseForward();

        System.out.println("Backward Playlist:");
        player.traverseBackward();

        player.recordPlayed(s1);
        player.recordPlayed(s2);

        player.showHistory();
    }
}
