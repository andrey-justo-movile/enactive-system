package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.Map;

public class LUISEntity {

    private String name;
    private String type;
    private int startIndex;
    private int endIndex;
    private double score;
    private Map<String, Object> resolution;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public double getScore() {
        return score;
    }

    public Map<String, Object> getResolution() {
        return resolution;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setResolution(Map<String, Object> resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "LUISEntity{ " +
                "name=" + name +
                ", type=" + type +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", score=" + score +
                ", resolution=" + resolution +
                '}';
    }
    
}
