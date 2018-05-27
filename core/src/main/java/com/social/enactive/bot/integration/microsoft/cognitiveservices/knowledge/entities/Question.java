package com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge.entities;

public class Question {
    
    private String question;
    private Long top;
    
    public Question() {}
    
    public Question(String question, Long top) {
        this.question = question;
        this.top = top;
    }
    
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public Long getTop() {
        return top;
    }
    public void setTop(Long top) {
        this.top = top;
    }
    
    @Override
    public String toString() {
        return "Question{ " +
                "question=" + question +
                ", top=" + top +
                '}';
    }
}
