package by.bsuir.lab4.command;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.lab4.constant.PageConstant;
import by.bsuir.lab4.constant.RequestConstant;

public class ToBookingRoomCommand implements Command {

    @Override
    public CommandResult execute(RequestContent requestContent) {
        String room = requestContent.getRequestParameter(RequestConstant.ROOM)[0];
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(RequestConstant.ROOM, room);
        return new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.BOOK_ROOM_PAGE, attributes);
    }
}
