package com.skypay.hotel;

import java.time.LocalDate;

/**
 * Represents a booking snapshot: user, room and dates and cost at booking time.
 */
public class Booking {
    private final int userId;
    private final int roomNumber;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final int pricePerNight;
    private final int totalCost;

    public Booking(int userId, int roomNumber,
                   LocalDate checkIn, LocalDate checkOut,
                   int pricePerNight) {
        this.userId = userId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.pricePerNight = pricePerNight;
        int nights = (int) (checkOut.toEpochDay() - checkIn.toEpochDay());
        this.totalCost = nights * pricePerNight;
    }

    public int getUserId() { return userId; }
    public int getRoomNumber() { return roomNumber; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public int getPricePerNight() { return pricePerNight; }
    public int getTotalCost() { return totalCost; }

    @Override
    public String toString() {
        return "Booking[user=" + userId
             + ", room=" + roomNumber
             + ", from=" + checkIn
             + ", to=" + checkOut
             + ", nights=" + (checkOut.toEpochDay()-checkIn.toEpochDay())
             + ", price=" + pricePerNight
             + ", total=" + totalCost + "]";
    }
}