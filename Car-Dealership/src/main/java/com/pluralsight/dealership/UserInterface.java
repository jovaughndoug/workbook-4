package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    static Dealership dealership;
    static DealershipFileManager fileManager;

    private static void init() {
        fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership("src/main/resources/inventory-backup.csv");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        boolean looper = true;
        while (looper) {


            System.out.println("""
                    ==========================
                    Welcome to the Dealership:
                    ==========================
                    What would you like to do:
                    1) Find vehicles within a price range
                    2) Find vehicles by make/model
                    3) Find vehicles by year range
                    4) Find vehicles by color
                    5) Find vehicles by mileage range
                    6) Find vehicles by type(car,truck,SUV,van)
                    7) List ALL vehicles
                    8) Add a vehicle
                    9) Remove a vehicle
                    99) Quit                                 
                    Please Select a number to continue.
                                    
                                 
                    """);
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "1":
                    System.out.println(" Enter Minimum Price: ");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println(" Enter Maximum Price: ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    listVehicles((ArrayList<Vehicle>) dealership.getVehiclesByPrice(minPrice,maxPrice));
                    break;
                case "2":
                    System.out.println(" Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.println(" Enter Model: ");
                    String model = scanner.nextLine();
                    listVehicles((ArrayList<Vehicle>) dealership.getVehicleByMakeModel(make, model));
                    break;
                case "3":
                    System.out.println(" Enter the year of the vehicle(minimum): ");
                    int minyYear = Integer.parseInt(scanner.nextLine());
                    System.out.println(" Enter the year of the vehicle(maximum): ");
                    int maxYear = Integer.parseInt((scanner.nextLine()));
                    listVehicles((ArrayList<Vehicle>) dealership.getVehiclesByYear(minyYear,maxYear));
                    break;
                case "4":
                    System.out.println(" Enter the color of the vehicle: ");
                    String vehicleColor = scanner.nextLine();
                    listVehicles((ArrayList<Vehicle>) dealership.getVehiclesByColor(vehicleColor));
                    break;
                case "5":
                    System.out.println(" Enter the Minimum Mileage: ");
                    int minMiles = Integer.parseInt(scanner.nextLine());
                    System.out.println(" Enter the Maximum Mileage: ");
                    int maxMiles = Integer.parseInt(scanner.nextLine());
                    listVehicles((ArrayList<Vehicle>) dealership.getVehiclesByMiles(minMiles,maxMiles));
                    break;
                case "6":
                    System.out.println(" Enter the Type of vehicle: ");
                    String type = scanner.nextLine();
                    listVehicles((ArrayList<Vehicle>) dealership.getByVehicleType(type));
                    break;
                case "7":
                    listVehicles((ArrayList<Vehicle>) dealership.getAllVehicles());
                    break;
                case "8":
                case "9":
                case "99":
                default:
                    System.out.println(" Sorry invalid Response Please Try Again :) ");


            }


        }
    }

    private static void listVehicles(ArrayList<Vehicle> vehicleArrayList) {
        for (Vehicle v : vehicleArrayList) {
            System.out.print(v);
        }
    }
}
