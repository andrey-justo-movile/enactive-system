package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.List;

public class LUISAction {
    
    private boolean triggered;
    private String name;
    private List<LUISParameter> parameters;

    public boolean getTrigerred() {
        return triggered;
    }

    public String getName() {
        return name;
    }

    public List<LUISParameter> getParams() {
        return parameters;
    }
    
    public void setParameters(List<LUISParameter> parameters) {
        this.parameters = parameters;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
    }

    @Override
    public String toString() {
        return "LUISEntity{ " +
                "name=" + name +
                ", triggered=" + triggered +
                ", parameters=" + parameters +
                '}';
    }
    
}
