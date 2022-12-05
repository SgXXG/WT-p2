package by.bsuir.lab4.specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingByUserSpecification implements Specification {

    private static final String BOOKING_BY_USER_SPECIFICATION = "SELECT booking_id,user_login,"
            + "room_number, arrival_date, departure_date, number_of_guests, guests, room.type, room.sleeps, room.cost"
            + " FROM booking INNER JOIN room ON room.number = booking.room_number WHERE user_login = ?";

    private String login;

    public BookingByUserSpecification(String login) {
        this.login = login;
    }

    @Override
    public PreparedStatement specify(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(BOOKING_BY_USER_SPECIFICATION);
        preparedStatement.setString(1, login);
        return preparedStatement;
    }
}
