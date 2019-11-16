package com.example.gupta.mujik;

public class Song {

    private final String cityName;
    private final int cityIcon;
    private final String temperature;
    private final Artist artist;

    public Song(String cityName, int cityIcon, String temperature, Artist artist) {
        this.cityName = cityName;
        this.cityIcon = cityIcon;
        this.temperature = temperature;
        this.artist = artist;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityIcon() {
        return cityIcon;
    }

    public String getTemperature() {
        return temperature;
    }

    public Artist getArtist() {
        return artist;
    }
}
