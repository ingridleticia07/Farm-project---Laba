package com.solvd.farm.model;
import com.solvd.farm.enums.SeasonType;

public class Season {
    private SeasonType type;
    private int duration;

    public Season(SeasonType type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Season{type=" + type + ", duration=" + duration + "}";
    }

    public SeasonType  getType() {
        return type;
    }

    public void setType(SeasonType type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
