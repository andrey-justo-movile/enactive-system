package com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge.entities;

import java.util.List;

public class Answers {
    
    public static final Double MIN_VALUE = 0D;
    public static final Double MAX_VALUE = 100D;
    
    private List<Answer> answers;
    
    public List<Answer> getAnswers() {
        return answers;
    }
    
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answers{ " +
                "answers=" + answers +
                '}';
    }
}
