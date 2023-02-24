package com.travelex.resolucao.exceptions;

public class ExceptionResponse {
    private String exceptionTime;
    private String customMessage;

    private String exceptionMessage;

    private String webRequestDescription;

    public ExceptionResponse(String exceptionTime, String customMessage, String exceptionMessage, String webRequestDescription) {
        this.exceptionTime = exceptionTime;
        this.customMessage = customMessage;
        this.exceptionMessage = exceptionMessage;
        this.webRequestDescription = webRequestDescription;
    }

    public String getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(String exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getWebRequestDescription() {
        return webRequestDescription;
    }

    public void setWebRequestDescription(String webRequestDescription) {
        this.webRequestDescription = webRequestDescription;
    }
}
