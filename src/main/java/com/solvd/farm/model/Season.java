package com.solvd.farm.model;

public class Season {
    private String seasonName;
    private int duration;

    public Season(String seasonName, int duration) {
        this.seasonName = seasonName;
        this.duration = duration;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
