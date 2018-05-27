package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.Map;

public class LUISParameterValue {

    private String name;
    private String type;
    private double score;
    private Map<String, Object> resolution;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getScore() {
        return score;
    }

    public Map<String, Object> getResolution() {
        return resolution;
    }
    
    public void setResolution(Map<String, Object> resolution) {
        this.resolution = resolution;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "LUISParameterValue{ " +
                "name=" + name +
                ", type=" + type +
                ", score=" + score +
                ", resolution=" + resolution +
                '}';
    }
    
}
