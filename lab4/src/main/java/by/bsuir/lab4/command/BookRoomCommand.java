package by.bsuir.lab4.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.constant.PageConstant;
import by.bsuir.lab4.constant.RequestConstant;
import by.bsuir.lab4.entity.Room;
import by.bsuir.lab4.entity.User;
import by.bsuir.lab4.exception.ServiceException;
import by.bsuir.lab4.message.MessageHandler;
import by.bsuir.lab4.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class BookRoomCommand implements Command {

    private static Logger log = LogManager.getLogger("booking room");

    private UserService userService;

    public BookRoomCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        User user = (User) requestContent.getSessionAttribute(RequestConstant.USER);
        String login = user.getLogin();
        String arrival = requestContent.getRequestParameter(RequestConstant.ARRIVAL)[0];
        String departure = requestContent.getRequestParameter(RequestConstant.DEPARTURE)[0];
        Room room = new Room();
        room.setNumber(Integer.parseInt(requestContent.getRequestParameter(RequestConstant.ROOM)[0]));
        int guestsNumber = Integer.parseInt(requestContent.getRequestParameter(RequestConstant.NUMBER_OF_GUESTS)[0]);
        String guestsNames = requestContent.getRequestParameter(RequestConstant.GUESTS_NAMES)[0];

        try {
            userService.addBooking(login, arrival, departure, room, guestsNumber, guestsNames);
        } catch (ServiceException e) {
            log.error("Error while booking room", e);
            return new DefaultCommand().execute(requestContent);
        }
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(RequestConstant.SUCCESSFUL_BOOKING, MessageHandler.getMessage("message.successful_book",
                (String) requestContent.getSessionAttribute(RequestConstant.LOCALE)));
        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.USER_MAIN_PAGE, attributes);
        log.debug("Room was successfully booked");
        return commandResult;
    }
}
