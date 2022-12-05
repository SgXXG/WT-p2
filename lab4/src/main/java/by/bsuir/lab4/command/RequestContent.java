package by.bsuir.lab4.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class RequestContent {

    private Map<String, Object> requestAttributes;
    private Map<String, String[]> requestParameters;
    private Map<String, Object> sessionAttributes;

    private RequestContent() {
    }

    public static RequestContent createContent(HttpServletRequest request) {
        RequestContent requestContent = new RequestContent();
        requestContent.setRequestAttributes(request);
        requestContent.setRequestParameters(request);
        requestContent.setSessionAttributes(request);
        return requestContent;
    }

    private void setRequestAttributes(HttpServletRequest request) {
        requestAttributes = new HashMap<>();
        Enumeration<String> attributes = request.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = attributes.nextElement();
            requestAttributes.put(attribute, request.getAttribute(attribute));
        }
    }

    private void setRequestParameters(HttpServletRequest request) {
        requestParameters = new HashMap<>();
        requestParameters.putAll(request.getParameterMap());
    }

    private void setSessionAttributes(HttpServletRequest request) {
        sessionAttributes = new HashMap<>();
        HttpSession session = request.getSession(true);
        Enumeration<String> sessionAttributesNames = session.getAttributeNames();
        while (sessionAttributesNames.hasMoreElements()) {
            String sessionAttribute = sessionAttributesNames.nextElement();
            sessionAttributes.put(sessionAttribute, session.getAttribute(sessionAttribute));
        }
    }

    public Map<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    public String[] getRequestParameter(String key) {
        return requestParameters.get(key);
    }

    public Map<String, String[]> getRequestParameters() {
        return requestParameters;
    }

    public Object getSessionAttribute(String key) {
        return sessionAttributes.get(key);
    }

    public Map<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

}
