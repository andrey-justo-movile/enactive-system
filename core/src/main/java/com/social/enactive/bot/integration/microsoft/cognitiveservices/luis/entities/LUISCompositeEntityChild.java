package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

public class LUISCompositeEntityChild {

    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "LUISCompositeEntityChild{ " +
                "type=" + type +
                ", value=" + value +
                '}';
    }
    
}
