package by.bsuir.lab4.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.entity.Booking;
import by.bsuir.lab4.entity.Room;
import by.bsuir.lab4.entity.User;
import by.bsuir.lab4.exception.RepositoryException;
import by.bsuir.lab4.exception.ServiceException;
import by.bsuir.lab4.repository.BookingRepository;
import by.bsuir.lab4.repository.UserRepository;
import by.bsuir.lab4.specification.Specification;
import by.bsuir.lab4.specification.UserLoginSpecification;

import java.time.LocalDate;
import java.util.List;

public class UserService {

    private static Logger log = LogManager.getLogger("user service");

    public List<User> login(String login, String password) throws ServiceException {
        List<User> users;

        Specification specification = new UserLoginSpecification(login, password);
        UserRepository repository = new UserRepository();
        try {
            users = repository.query(specification);
        } catch (RepositoryException e) {
            log.error("RepositoryException while login");
            throw new ServiceException(e);
        }
        return users;
    }

    public User register(String login, String password, String email, String firstName, String lastName,
            String phoneNumber, String country, String birthday, boolean isAdmin) throws ServiceException {

        UserRepository repository = new UserRepository();
        User user = new User(login, password, firstName, lastName, email, country, phoneNumber,
                LocalDate.parse(birthday), isAdmin);
        try {
            repository.add(user);
        } catch (RepositoryException e) {
            log.error("RepositoryException while registering new user");
            throw new ServiceException(e);
        }
        return user;
    }

    public Booking addBooking(String userLogin, String arrival, String departure, Room room, int guestsNumber,
            String guestName) throws ServiceException {
        BookingRepository repository = new BookingRepository();
        Booking booking = new Booking(userLogin, LocalDate.parse(arrival), LocalDate.parse(departure), room,
                guestsNumber, guestName);
        try {
            repository.add(booking);
        } catch (RepositoryException e) {
            log.error("RepositoryException while add booking", e);
            throw new ServiceException(e);
        }
        return booking;
    }

    public User updateProfile(String login, String password, String email, String firstName, String lastName,
            String phoneNumber, String country, String birthday, boolean isAdmin) throws ServiceException {

        UserRepository repository = new UserRepository();
        User user = new User(login, password, firstName, lastName, email, country, phoneNumber,
                LocalDate.parse(birthday), isAdmin);
        try {
            repository.update(user);
        } catch (RepositoryException e) {
            log.error("RepositoryException while registering new user");
            throw new ServiceException(e);
        }
        return user;

    }
}
