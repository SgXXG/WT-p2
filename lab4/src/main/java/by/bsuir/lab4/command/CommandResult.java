package by.bsuir.lab4.command;

import java.util.HashMap;
import java.util.Map;

public class CommandResult {
    public enum ResponseType {
        FORWARD, REDIRECT
    }

    private ResponseType responseType;
    private String page;
    private Map<String, Object> attributes;
    private Map<String, Object> sessionAttributes;

    public CommandResult() {
    }

    public CommandResult(ResponseType responseType, String page, Map<String, Object> attributes) {
        this.responseType = responseType;
        this.page = page;
        this.attributes = attributes;
        sessionAttributes = new HashMap<>();
    }

    public CommandResult(ResponseType responseType, String page) {
        this.responseType = responseType;
        this.page = page;
        this.attributes = new HashMap<>();
        this.sessionAttributes = new HashMap<>();
    }

    public CommandResult(ResponseType responseType, String page, Map<String, Object> attributes,
            Map<String, Object> sessionAttributes) {
        this.responseType = responseType;
        this.page = page;
        this.attributes = attributes;
        this.sessionAttributes = sessionAttributes;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public String getPage() {
        return page;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Map<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }
}
