package com.example.gupta.mujik;

public enum Artist {

    PERIODIC_CLOUDS("Periodic Clouds"),
    CLOUDY("Cloudy"),
    MOSTLY_CLOUDY("Mostly Cloudy"),
    PARTLY_CLOUDY("Partly Cloudy"),
    CLEAR("Clear");

    private String displayName;

    Artist(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
