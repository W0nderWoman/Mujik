package com.example.gupta.mujik;

import android.net.Uri;

public class Song {

    private final String song;
    private final Uri url;
    private final Artist artist;
    private final Uri coverimg;

    public Song(String song, Uri url, Uri coverimg, Artist artist) {
        this.song = song;
        this.url = url;
        this.coverimg = coverimg;
        this.artist = artist;
    }

    public String getSongName() {
        return song;
    }

    public Uri getSongImg() {
        return coverimg;
    }

    public Uri getSongurl() {
        return url;
    }

    public Artist getArtist() {
        return artist;
    }
}
