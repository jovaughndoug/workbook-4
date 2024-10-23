package com.pluralsight.hotelOperations;

public class Employee {
    private String employeeid;
    private String name;
    private String department;
    private Double payRate;
    private Double hoursWorked;
    private Double overtimeHours;

    public Double getPayRate() {
        return payRate;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }
    public Double getTotalPay(){
        return hoursWorked * payRate;
    }
    public Double getRegularHours(){
        return hoursWorked;
    }
    public Double getOvertimePay(){
        return (payRate*1.5) * overtimeHours;


    }
}
