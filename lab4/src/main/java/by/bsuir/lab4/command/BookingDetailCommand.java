package by.bsuir.lab4.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.bsuir.lab4.constant.PageConstant;
import by.bsuir.lab4.constant.RequestConstant;
import by.bsuir.lab4.entity.Booking;
import by.bsuir.lab4.exception.ServiceException;
import by.bsuir.lab4.message.MessageHandler;
import by.bsuir.lab4.service.CommonService;

import org.apache.log4j.LogManager;

public class BookingDetailCommand implements Command {

    private static Logger log = LogManager.getLogger("booking detail");

    private CommonService commonService;

    public BookingDetailCommand(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        int bookingId = Integer.parseInt(requestContent.getRequestParameter(RequestConstant.BOOKING_ID)[0]);
        Map<String, Object> requestAttributes = new HashMap<>();
        try {
            List<Booking> bookingList = commonService.findBookingById(bookingId);
            if (bookingList.isEmpty()) {
                requestAttributes.put(RequestConstant.ERROR_FINDING_BOOKINGS, MessageHandler.getMessage(
                        "message.no_bookings", (String) requestContent.getSessionAttribute(RequestConstant.LOCALE)));
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.BOOKINGS_PAGE,
                        requestAttributes);
            } else {
                Booking booking = bookingList.get(0);
                requestAttributes.put(RequestConstant.BOOKING, booking);
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.BOOKING_DETAIL_PAGE,
                        requestAttributes);
            }
            return commandResult;
        } catch (ServiceException e) {
            log.error("Error in receiving bookings");
            return new DefaultCommand().execute(requestContent);
        }
    }
}
