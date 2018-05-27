package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.entities;

import java.util.List;

public class SpeechRecognize {

    private String version;
    private SpeechTranscriptionPossibility header;
    private List<SpeechTranscriptionPossibility> results;
    
    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }


    public SpeechTranscriptionPossibility getHeader() {
        return header;
    }


    public void setHeader(SpeechTranscriptionPossibility header) {
        this.header = header;
    }


    public List<SpeechTranscriptionPossibility> getResults() {
        return results;
    }


    public void setResults(List<SpeechTranscriptionPossibility> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "SpeechRecognition{ " +
                "version=" + version +
                ", header=" + header +
                ", results=" + results +
                '}';
    }

}
