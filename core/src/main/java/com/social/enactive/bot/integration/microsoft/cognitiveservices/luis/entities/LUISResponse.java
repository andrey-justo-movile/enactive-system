package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.List;

public class LUISResponse {

    private String query;
    private LUISIntent topScoringIntent;
    private List<LUISIntent> intents;
    private List<LUISEntity> entities;
    private List<LUISCompositeEntity> compositeEntities;
    private LUISDialog dialog;

    public String getQuery() {
        return query;
    }

    public List<LUISIntent> getIntents() {
        return intents;
    }

    public List<LUISEntity> getEntities() {
        return entities;
    }

    public List<LUISCompositeEntity> getCompositeEntities() {
        return compositeEntities;
    }

    public LUISDialog getDialog() {
        return dialog;
    }
    
    public LUISIntent getTopScoringIntent() {
        return topScoringIntent;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public void setTopScoringIntent(LUISIntent topScoringIntent) {
        this.topScoringIntent = topScoringIntent;
    }

    public void setIntents(List<LUISIntent> intents) {
        this.intents = intents;
    }

    public void setEntities(List<LUISEntity> entities) {
        this.entities = entities;
    }

    public void setCompositeEntities(List<LUISCompositeEntity> compositeEntities) {
        this.compositeEntities = compositeEntities;
    }

    public void setDialog(LUISDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public String toString() {
        return "LUISResponse{ " +
                "query=" + query +
                ", intents=" + intents +
                ", entities=" + entities +
                ", topScoringIntent=" + topScoringIntent +
                ", compositeEntities=" + compositeEntities +
                '}';
    }
    
}
