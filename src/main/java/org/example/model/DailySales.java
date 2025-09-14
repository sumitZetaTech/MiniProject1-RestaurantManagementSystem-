package org.example.model;

public class DailySales {
    int bookingId;
    int amountPaid;

    public DailySales(int bookingId, int amountPaid) {
        this.bookingId = bookingId;
        this.amountPaid = amountPaid;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }
}
