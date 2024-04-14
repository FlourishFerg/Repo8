package com.example.repo8;

import java.util.List;

public class Repo8 {

    // Enum for music genres
    enum Genre {
        POP, ROCK, HIPHOP, CLASSICAL, JAZZ, ELECTRONIC
    }

    // Class representing a music track
    class Track {
        private String title;
        private String artist;
        private Genre genre;
        private int duration; // in seconds

        public Track(String title, String artist, Genre genre, int duration) {
            this.title = title;
            this.artist = artist;
            this.genre = genre;
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public Genre getGenre() {
            return genre;
        }

        public int getDuration() {
            return duration;
        }
    }

    // Class representing a user
    class User {
        private String username;
        private String password;
        private List<Track> playlist;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.playlist = new ArrayList<>();
        }

        public String getUsername() {
            return username;
        }

        public boolean authenticate(String password) {
            return this.password.equals(password);
        }

        public void addToPlaylist(Track track) {
            playlist.add(track);
        }

        public List<Track> getPlaylist() {
            return playlist;
        }
    }

    // Class representing the music streaming service
    public class MusicStreamingService {
        private Map<String, User> users;
        private List<Track> tracks;

        public MusicStreamingService() {
            this.users = new HashMap<>();
            this.tracks = new ArrayList<>();
        }

        public void registerUser(String username, String password) {
            users.put(username, new User(username, password));
        }

        public boolean authenticateUser(String username, String password) {
            User user = users.get(username);
            return user != null && user.authenticate(password);
        }

        public void addTrack(String title, String artist, Genre genre, int duration) {
            tracks.add(new Track(title, artist, genre, duration));
        }

        public List<Track> searchTracks(String keyword) {
            List<Track> searchResults = new ArrayList<>();
            for (Track track : tracks) {
                if (track.getTitle().toLowerCase().contains(keyword.toLowerCase()) || track.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                    searchResults.add(track);
                }
            }
            return searchResults;
        }

        // Other methods for streaming, playlist management, recommendations, etc.

        public static void main(String[] args) {
            MusicStreamingService service = new MusicStreamingService();
            service.registerUser("user1", "password1");
            service.registerUser("user2", "password2");
            service.addTrack("Song 1", "Artist 1", Genre.POP, 240);
            service.addTrack("Song 2", "Artist 2", Genre.ROCK, 300);

            // Example usage:
            if (service.authenticateUser("user1", "password1")) {
                List<Track> searchResults = service.searchTracks("song");
                for (Track track : searchResults) {
                    System.out.println(track.getTitle() + " by " + track.getArtist());
                }
            }
        }
    }

}
