package by.bsuir.lab4.specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Specification {
     PreparedStatement specify(Connection connection) throws SQLException;
}
