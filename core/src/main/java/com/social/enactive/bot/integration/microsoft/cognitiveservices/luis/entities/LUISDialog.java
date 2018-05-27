package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities;

public class LUISDialog {

    private String prompt;
    private String parameterName;
    private String contextId;
    private String status;
    private String finished;

    public String getPrompt() {
        return prompt;
    }

    public String getParameterName() {
        return parameterName;
    }

    public String getContextId() {
        return contextId;
    }

    public String getStatus() {
        return status;
    }
    
    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LUISDialog{ " +
                "prompt=" + prompt +
                ", parameterName=" + parameterName +
                ", contextId=" + contextId +
                ", status=" + status +
                ", finished=" + finished +
                '}';
    }
    
}
