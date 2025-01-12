package com.example.music_list.service;

import com.example.music_list.model.Music;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FileStorageService {
    private List<Music> songs = new ArrayList<>();
    private static final List<String> VALID_EXTENSIONS = Arrays.asList(".mp3", ".wav", ".ogg", ".m4p");
    private static final String MUSIC_DIR = "D:/Nhạc/";

    public void addSong(Music song) {
        songs.add(song);
    }

    public List<Music> getAllSongs() {
        return songs;
    }

    public void loadSongsFromDirectory() {
        File musicDir = new File(MUSIC_DIR);
        if (musicDir.exists() && musicDir.isDirectory()) {
            File[] files = musicDir.listFiles((dir, name) ->
                    VALID_EXTENSIONS.stream().anyMatch(name::endsWith)
            );

            if (files != null) {
                for (File file : files) {
                    Music song = new Music();
                    song.setName(file.getName());
                    song.setFilePath(file.getAbsolutePath());
                    song.setArtist("Unknown");
                    song.setGenre("Unknown");
                    songs.add(song);
                }
            }
        }
    }
}
