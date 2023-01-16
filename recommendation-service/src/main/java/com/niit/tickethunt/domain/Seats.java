package com.niit.tickethunt.domain;

public class Seats {
    private String seatNumber;
    private double price;
    private String dateOfBooking;

    public Seats(String seatNumber, double price, String dateOfBooking) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.dateOfBooking = dateOfBooking;
    }

    public Seats() {
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }
}