package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech;

public enum SpeechLanguages {
    
    PT_BR("pt-BR"),
    EN_US("en-US"),
    ES_ES("es-ES")
    ;
    
    private String lang;
    
    private SpeechLanguages(String lang) {
        this.lang = lang;
    }
    
    public String getLang() {
        return lang;
    }
    
}
