package by.bsuir.lab4.entity;

import java.math.BigDecimal;

public class Room extends Entity {

    private int number;
    private RoomType roomType;
    private int sleeps;
    private BigDecimal cost;

    public Room() {
    }

    public Room(int number, RoomType roomType, int sleeps, BigDecimal cost) {
        this.number = number;
        this.roomType = roomType;
        this.sleeps = sleeps;
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getSleeps() {
        return sleeps;
    }

    public void setSleeps(int sleeps) {
        this.sleeps = sleeps;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
