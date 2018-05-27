package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

import java.util.List;

public class LUISCompositeEntity {
    
    private String parentType;
    private String value;
    private List<LUISCompositeEntityChild> children;

    public String getParentType() {
        return parentType;
    }

    public String getValue() {
        return value;
    }

    public List<LUISCompositeEntityChild> getChildren() {
        return children;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setChildren(List<LUISCompositeEntityChild> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "LUISCompositeEntity{ " +
                "parentType=" + parentType +
                ", value=" + value +
                ", children=" + children +
                '}';
    }
    
}
