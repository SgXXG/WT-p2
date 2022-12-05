package by.bsuir.lab4.command;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.lab4.constant.RequestConstant;

public class LanguageCommand implements Command {

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        String page = requestContent.getRequestParameter(RequestConstant.PAGE)[0];
        String locale = requestContent.getRequestParameter(RequestConstant.LOCALE)[0];

        Map<String, Object> attributes = new HashMap<>();
        attributes.put(RequestConstant.LOCALE, locale);
        Map<String, Object> sessionAttributes = new HashMap<>();
        sessionAttributes.put(RequestConstant.LOCALE, locale);
        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, page, attributes, sessionAttributes);
        return commandResult;
    }
}
