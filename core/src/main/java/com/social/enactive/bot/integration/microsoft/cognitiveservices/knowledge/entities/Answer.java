package com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge.entities;

import java.util.List;

public class Answer {

    private String answer;
    private List<String> questions;
    private Double score;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Answer{ " + "answer=" + answer + ", questions=" + questions + ", score=" + score + '}';
    }
}
