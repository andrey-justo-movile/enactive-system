package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.entities;

import com.social.enactive.bot.components.user.Gender;

public enum VoiceSynthesisType {

    ZIRA_US("Microsoft Server Speech Text to Speech Voice (en-US, ZiraRUS)", Gender.FEMALE),
    HELOISA_PT_BR("Microsoft Server Speech Text to Speech Voice (pt-BR, HeloisaRUS)", Gender.FEMALE),
    DANIEL_PT_BR("Microsoft Server Speech Text to Speech Voice (pt-BR, Daniel, Apollo)", Gender.MALE);

    private String name;
    private Gender gender;

    private VoiceSynthesisType(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
