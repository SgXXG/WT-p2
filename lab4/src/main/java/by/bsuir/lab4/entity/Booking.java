package by.bsuir.lab4.entity;

import java.time.LocalDate;

public class Booking extends Entity {
    private int bookingId;
    private String login;
    private LocalDate arrival;
    private LocalDate departure;
    private Room room;
    private int guestsNumber;
    private String guestName;

    public Booking() {
    }

    public Booking(int bookingId, String login, LocalDate arrival, LocalDate departure, Room room, int guestsNumber,
            String guestName) {
        this.bookingId = bookingId;
        this.login = login;
        this.arrival = arrival;
        this.departure = departure;
        this.room = room;
        this.guestsNumber = guestsNumber;
        this.guestName = guestName;
    }

    public Booking(String login, LocalDate arrival, LocalDate departure, Room room, int guestsNumber,
            String guestName) {
        this.login = login;
        this.arrival = arrival;
        this.departure = departure;
        this.room = room;
        this.guestsNumber = guestsNumber;
        this.guestName = guestName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(int guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getUserLogin() {
        return login;
    }

    public void setUserLogin(String login) {
        this.login = login;
    }
}
