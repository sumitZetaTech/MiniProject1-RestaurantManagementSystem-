package org.example.model;

import java.sql.Timestamp;

public class Booking {
    private int id;
    private int userId;
    private int bookingCode;
    private String bookingStatus;
    private Timestamp bookingDatetime;

    // 🔹 Empty Constructor
    public Booking() {}

    // 🔹 All-args Constructor
    public Booking(int id, int userId, int bookingCode, String bookingStatus, Timestamp bookingDatetime) {
        this.id = id;
        this.userId = userId;
        this.bookingCode = bookingCode;
        this.bookingStatus = bookingStatus;
        this.bookingDatetime = bookingDatetime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Timestamp getBookingDatetime() {
        return bookingDatetime;
    }

    public void setBookingDatetime(Timestamp bookingDatetime) {
        this.bookingDatetime = bookingDatetime;
    }

    // Optional: toString for debugging
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookingCode=" + bookingCode +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", bookingDatetime=" + bookingDatetime +
                '}';
    }
}
