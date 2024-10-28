package com.pluralsight.dealership;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
     Dealership dealership;
     DealershipFileManager fileManager;

    private  void init() {
        fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership("src/main/resources/inventory-backup.csv");

    }

    public   void showUi() {
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
                    listVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
                    break;
                case "2":
                    System.out.println(" Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.println(" Enter Model: ");
                    String model = scanner.nextLine();
                    listVehicles(dealership.getVehicleByMakeModel(make, model));
                    break;
                case "3":
                    System.out.println(" Enter the year of the vehicle(minimum): ");
                    int minyYear = Integer.parseInt(scanner.nextLine());
                    System.out.println(" Enter the year of the vehicle(maximum): ");
                    int maxYear = Integer.parseInt((scanner.nextLine()));
                    listVehicles(dealership.getVehiclesByYear(minyYear, maxYear));
                    break;
                case "4":
                    System.out.println(" Enter the color of the vehicle: ");
                    String vehicleColor = scanner.nextLine();
                    listVehicles( dealership.getVehiclesByColor(vehicleColor));
                    break;
                case "5":
                    System.out.println(" Enter the Minimum Mileage: ");
                    int minMiles = Integer.parseInt(scanner.nextLine());
                    System.out.println(" Enter the Maximum Mileage: ");
                    int maxMiles = Integer.parseInt(scanner.nextLine());
                    listVehicles( dealership.getVehiclesByMiles(minMiles, maxMiles));
                    break;
                case "6":
                    System.out.println(" Enter the Type of vehicle: ");
                    String type = scanner.nextLine();
                    listVehicles( dealership.getByVehicleType(type));
                    break;
                case "7":
                    listVehicles(dealership.getAllVehicles());
                    break;
                case "8":
                    addVehicleScreen(scanner);
                    break;

                case "9":
                    removeVehicleScreen(scanner);
                    break;
                case "99":
                    looper=false;
                    break;

                default:
                    System.out.println(" Sorry invalid Response Please Try Again :) ");


            }


        }
    }

    private  void listVehicles(List<Vehicle> vehicleArrayList) {
        for (Vehicle v : vehicleArrayList) {
            System.out.printf("%30s, %30s, %30s, %30s, %30d\n",v.getModel(), v.getMake(), v.getVehicleType(),v.getColor(),v.getOdometer());
        }
    }

    private  void addVehicleScreen(Scanner inputScanner) {
        System.out.print("Enter VIN: ");
        int vin = Integer.parseInt(inputScanner.nextLine());
        System.out.print("Enter Year: ");
        int year = Integer.parseInt(inputScanner.nextLine());
        System.out.print("Enter Make: ");
        String make = inputScanner.nextLine();
        System.out.print("Enter Model: ");
        String model = inputScanner.nextLine();
        System.out.print("Enter Type: ");
        String type = inputScanner.nextLine();
        System.out.print("Enter Color: ");
        String color = inputScanner.nextLine();
        System.out.print("Enter Odometer: ");
        int odometer = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.print("Enter Price: ");
        double price = inputScanner.nextDouble();
        inputScanner.nextLine();
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);
    }

    private  void removeVehicleScreen(Scanner inputScanner) {
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = Integer.parseInt(inputScanner.nextLine());
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed.");
                fileManager.saveDealership(dealership);
                return;

            }
        }
    }
}
