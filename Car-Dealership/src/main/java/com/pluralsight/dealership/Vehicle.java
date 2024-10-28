package com.pluralsight.dealership;

public class Vehicle {
    private Integer vin;
    private Integer year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private Integer odometer;
    private Double price;

    @Override
    public String toString() {
        return "Vehicle" +
                "vin=" + vin +
                " year=" + year +
                " make='" + make +
                " model='" + model +
                " vehicleType='" + vehicleType +
                " color='" + color +
                " odometer=" + odometer +
                " price=" + price
                ;
    }

    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOdometer() {
        return odometer;
    }

    public void setOdometer(Integer odometer) {
        this.odometer = odometer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Vehicle(Integer vin, Integer year, String make, String model, String vehicleType, String color, Integer odometer, Double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
}
