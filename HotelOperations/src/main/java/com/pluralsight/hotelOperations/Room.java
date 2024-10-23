package com.pluralsight.hotelOperations;

public class Room {
    private Integer numberofBeds;
    private Double price;
    private Boolean isOccupied;
    private Boolean isDirty;
    private Boolean isAvailable;

    public int getNumberofBeds() {
        return numberofBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}


