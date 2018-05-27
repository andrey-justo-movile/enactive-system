package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.entities;

import java.util.Map;

public class SpeechTranscriptionPossibility {

    private Double confidence;
    private String lexical;
    private String name;
    private String scenario;
    private String status;
    private Map<String, String> properties;

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public String getLexical() {
        return lexical;
    }

    public void setLexical(String lexical) {
        this.lexical = lexical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "SpeechTranscriptionPossibility{ " + "confidence=" + confidence + ", lexical=" + lexical + ", name=" + name + ", scenario=" + scenario
                + ", status=" + status + ", properties=" + properties + '}';
    }

}
