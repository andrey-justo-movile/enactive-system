package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.entities;

import com.social.enactive.bot.components.user.Gender;

public class SpeechSynthesis {

    private final String language;
    private final String text;
    private final VoiceSynthesisType type;

    public SpeechSynthesis(String text) {
        this(VoiceSynthesisType.HELOISA_PT_BR, "pt-BR", text);
    }

    public SpeechSynthesis(VoiceSynthesisType type, String text) {
        this(type, "pt-BR", text);
    }

    public SpeechSynthesis(VoiceSynthesisType type, String language, String text) {
        this.type = type;
        this.language = language;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getLanguage() {
        return language;
    }

    public VoiceSynthesisType getType() {
        return type;
    }

    public String generateBody() {
        return "<speak version='1.0' xml:lang='" + language + "'>" +
                "<voice xml:lang='" + language + "' xml:gender='" + type.getGender() + "' name='" + type.getName() + "'>" +
                text +
                "</voice>" +
                "</speak>";
    }
}
