package com.pluralsight.dealership;

import java.io.*;


public class DealershipFileManager {


    public Dealership getDealership(String file) {

        Dealership dealership = null;
        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String dealershipInfo = bufferedReader.readLine();
            String[] dataParts = dealershipInfo.split("\\|");
            String dealershipName = dataParts[0];
            String dealershipAddress = dataParts[1];
            String dealershipNumber = dataParts[2];
            dealership = new Dealership(dealershipName, dealershipAddress,dealershipNumber);
            String vehicleInfo;
            while ((vehicleInfo = bufferedReader.readLine()) != null) {
                dataParts = vehicleInfo.split("\\|");
                try {
                    int vin = Integer.parseInt(dataParts[0]);
                    int year = Integer.parseInt(dataParts[1]);
                    String make = dataParts[2];
                    String model = dataParts[3];
                    String vehicleType = dataParts[4];
                    String color = dataParts[5];
                    int odometer = Integer.parseInt(dataParts[6]);
                    double price = Double.parseDouble(dataParts[7]);
                    dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                } catch (Exception e) {
                    System.out.println(" Data Part isn't valid for vehicle");
                }
            }
        } catch (Exception e) {
            System.out.println(" File is not able to be read");
           // throw new RuntimeException(e);

        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter("./src/main/resources/inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhone()));
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bufferedWriter.write(vehicle.toString());
            }
        } catch (IOException e) {
            System.out.println(" You Messed Up Writing the File Go Back");
            throw new RuntimeException(e);

        }

    }
}
