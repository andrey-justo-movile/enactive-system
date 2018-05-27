package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.List;

public class LUISIntent {

    private String intent;
    private double score;
    private List<LUISAction> actions;

    public String getIntent() {
        return intent;
    }

    public double getScore() {
        return score;
    }

    public List<LUISAction> getActions() {
        return actions;
    }
    
    public void setIntent(String intent) {
        this.intent = intent;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setActions(List<LUISAction> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "LUISIntent{ " +
                "intent=" + intent +
                ", score=" + score +
                ", actions=" + actions +
                '}';
    }
    
}
