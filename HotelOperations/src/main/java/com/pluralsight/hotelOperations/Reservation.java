package com.pluralsight.hotelOperations;

public class Reservation {
    private  Double price;
    private Boolean isWeekend;
    private Double ReservationTotal;
    private  String roomType;
    private Integer numberOFNights;

    public Reservation(Double price, Boolean isWeekend, Double reservationTotal, String roomType, Integer numberOFNights) {
        this.price = price;
        this.isWeekend = isWeekend;
        ReservationTotal = reservationTotal;
        this.roomType = roomType;
        this.numberOFNights = numberOFNights;
    }

    public void setWeekend(Boolean weekend) {
        isWeekend = weekend;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setNumberOFNights(Integer numberOFNights) {
        this.numberOFNights = numberOFNights;
    }

    public Double getPrice() {
        return price;
    }

    public Double getReservationTotal() {
        return ReservationTotal;
    }

    public String getRoomType() {
        return roomType;
    }

    public Integer getNumberOFNights() {
        return numberOFNights;
    }
}
