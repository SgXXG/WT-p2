package by.bsuir.lab4.specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingByIdSpecification implements Specification {

    private static final String BOOKING_BY_ID_SPECIFICATION = "SELECT booking_id,user_login,"
            + "room_number, arrival_date, departure_date, number_of_guests, guests, room.type, room.sleeps, room.cost"
            + " FROM booking INNER JOIN room ON room.number = booking.room_number WHERE booking_id = ?";

    private int bookingId;

    public BookingByIdSpecification(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public PreparedStatement specify(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(BOOKING_BY_ID_SPECIFICATION);
        preparedStatement.setInt(1, bookingId);
        return preparedStatement;
    }
}
