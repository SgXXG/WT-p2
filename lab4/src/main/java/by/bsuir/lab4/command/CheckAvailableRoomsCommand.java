package by.bsuir.lab4.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.constant.PageConstant;
import by.bsuir.lab4.constant.RequestConstant;
import by.bsuir.lab4.entity.Room;
import by.bsuir.lab4.exception.ServiceException;
import by.bsuir.lab4.message.MessageHandler;
import by.bsuir.lab4.service.CommonService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAvailableRoomsCommand implements Command {

    private static Logger log = LogManager.getLogger("check available rooms");

    private CommonService commonService;

    public CheckAvailableRoomsCommand(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        String arrivalDate = requestContent.getRequestParameter(RequestConstant.ARRIVAL)[0];
        String departureDate = requestContent.getRequestParameter(RequestConstant.DEPARTURE)[0];
        try {
            Map<String, Object> requestAttributes = new HashMap<>();
            Map<String, Object> sessionAttributes = new HashMap<>();
            List<Room> roomList = commonService.findAvailableRooms(arrivalDate, departureDate);
            if (roomList.isEmpty()) {
                requestAttributes.put(RequestConstant.NO_AVAILABLE_ROOMS,
                        MessageHandler.getMessage("message.no_available_rooms",
                                (String) requestContent.getSessionAttribute(RequestConstant.LOCALE)));
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.USER_MAIN_PAGE,
                        requestAttributes);
            } else {
                requestAttributes.put(RequestConstant.ROOMS, roomList);
                sessionAttributes.put(RequestConstant.ARRIVAL, arrivalDate);
                sessionAttributes.put(RequestConstant.DEPARTURE, departureDate);
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.AVAILABLE_ROOMS,
                        requestAttributes, sessionAttributes);
            }
            return commandResult;
        } catch (ServiceException e) {
            log.error("Error while receiving rooms", e);
            return new DefaultCommand().execute(requestContent);
        }
    }
}
