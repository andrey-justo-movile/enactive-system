package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.List;

public class LUISParameter {
    
    private String name;
    private boolean required;
    private List<LUISParameterValue> parameterValues;

    public String getName() {
        return name;
    }

    public boolean getRequired() {
        return required;
    }
    
    public List<LUISParameterValue> getParameterValues() {
        return parameterValues;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setParameterValues(List<LUISParameterValue> parameterValues) {
        this.parameterValues = parameterValues;
    }
    
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "LUISIntent{ " +
                "name=" + name +
                ", required=" + required +
                ", parameterValues=" + parameterValues +
                '}';
    }

}
