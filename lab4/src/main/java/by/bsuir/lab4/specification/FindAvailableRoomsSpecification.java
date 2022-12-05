package by.bsuir.lab4.specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FindAvailableRoomsSpecification implements Specification {

    private static final String AVAILABLE_ROOM_BY_DATES = "SELECT room.number, room.type, room.sleeps, room.cost FROM room"
            + " LEFT JOIN booking ON room.number = booking.room_number"
            + " WHERE ((DAYOFYEAR(booking.arrival_date) > DAYOFYEAR(?))"
            + "  AND (DAYOFYEAR(booking.arrival_date) > DAYOFYEAR(?))) OR"
            + "  ((DAYOFYEAR(booking.departure_date) < DAYOFYEAR(?))"
            + "    AND (DAYOFYEAR(booking.departure_date) < DAYOFYEAR(?))) OR"
            + "  ((DAYOFYEAR(booking.arrival_date) IS NULL) AND (DAYOFYEAR(booking.departure_date) IS NULL));";

    private String arrival;
    private String departure;

    public FindAvailableRoomsSpecification(String arrival, String departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    @Override
    public PreparedStatement specify(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AVAILABLE_ROOM_BY_DATES);
        preparedStatement.setString(1, arrival);
        preparedStatement.setString(2, departure);
        preparedStatement.setString(3, arrival);
        preparedStatement.setString(4, departure);
        return preparedStatement;
    }
}
