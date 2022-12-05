package by.bsuir.lab4.command;

import by.bsuir.lab4.service.CommonService;
import by.bsuir.lab4.service.UserService;

public enum CommandType {
    LOGIN(new LoginCommand(new UserService())), REGISTER(new RegisterCommand(new UserService())),
    LOGOUT(new LogoutCommand()), TO_REGISTRATION(new ToRegistrationCommand()), TO_LOGIN(new ToLoginCommand()),
    BOOKINGS(new ShowBookingsCommand(new CommonService())), BOOK_ROOM(new BookRoomCommand(new UserService())),
    TO_BOOKING(new ToBookingRoomCommand()), CHECK_DATES(new CheckAvailableRoomsCommand(new CommonService())),
    CHANGE_LANGUAGE(new LanguageCommand()), CANCEL_BOOKING(new CancelBookingCommand(new CommonService())),
    BOOKING_DETAIL(new BookingDetailCommand(new CommonService())), TO_PROFILE(new ToUserProfileCommand()),;

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
