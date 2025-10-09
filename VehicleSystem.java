import java.util.Scanner;

// Vehicle interface: common contract for all vehicles
interface Vehicle {
    String getMake();
    String getModel();
    int getYear();
}

// CarVehicle interface: specific to cars
interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();

    void setFuelType(String fuelType);
    String getFuelType();
}

// MotorVehicle interface: specific to motorcycles
interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();

    void setMotorcycleType(String type);
    String getMotorcycleType();
}

// TruckVehicle interface: specific to trucks
interface TruckVehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();

    void setTransmissionType(String transmission);
    String getTransmissionType();
}

// Car class implementing Vehicle and CarVehicle interfaces
class Car implements Vehicle, CarVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfDoors;
    private String fuelType;

    // Constructor
    public Car(String make, String model, int year, int doors, String fuel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfDoors = doors;
        this.fuelType = fuel;
    }

    // Vehicle methods
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    // CarVehicle methods
    public void setNumberOfDoors(int doors) { this.numberOfDoors = doors; }
    public int getNumberOfDoors() { return numberOfDoors; }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public String getFuelType() { return fuelType; }

    public void displayInfo() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
        System.out.println("Doors: " + numberOfDoors + ", Fuel Type: " + fuelType);
    }
}

// Motorcycle class implementing Vehicle and MotorVehicle interfaces
class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String type;

    // Constructor
    public Motorcycle(String make, String model, int year, int wheels, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfWheels = wheels;
        this.type = type;
    }

    // Vehicle methods
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    // MotorVehicle methods
    public void setNumberOfWheels(int wheels) { this.numberOfWheels = wheels; }
    public int getNumberOfWheels() { return numberOfWheels; }

    public void setMotorcycleType(String type) { this.type = type; }
    public String getMotorcycleType() { return type; }

    public void displayInfo() {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
        System.out.println("Wheels: " + numberOfWheels + ", Type: " + type);
    }
}

// Truck class implementing Vehicle and TruckVehicle interfaces
class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmission;

    // Constructor
    public Truck(String make, String model, int year, double capacity, String transmission) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.cargoCapacity = capacity;
        this.transmission = transmission;
    }

    // Vehicle methods
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    // TruckVehicle methods
    public void setCargoCapacity(double capacity) { this.cargoCapacity = capacity; }
    public double getCargoCapacity() { return cargoCapacity; }

    public void setTransmissionType(String transmission) { this.transmission = transmission; }
    public String getTransmissionType() { return transmission; }

    public void displayInfo() {
        System.out.println("Truck Details:");
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons, Transmission: " + transmission);
    }
}

// Main program
public class VehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Vehicle System ---");
            System.out.println("1. Add Car");
            System.out.println("2. Add Motorcycle");
            System.out.println("3. Add Truck");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter make: "); String carMake = sc.nextLine();
                    System.out.print("Enter model: "); String carModel = sc.nextLine();
                    System.out.print("Enter year: "); int carYear = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter number of doors: "); int doors = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter fuel type (petrol/diesel/electric): "); String fuel = sc.nextLine();
                    Car car = new Car(carMake, carModel, carYear, doors, fuel);
                    car.displayInfo();
                    break;

                case 2:
                    System.out.print("Enter make: "); String motoMake = sc.nextLine();
                    System.out.print("Enter model: "); String motoModel = sc.nextLine();
                    System.out.print("Enter year: "); int motoYear = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter number of wheels: "); int wheels = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter type (sport/cruiser/off-road): "); String motoType = sc.nextLine();
                    Motorcycle moto = new Motorcycle(motoMake, motoModel, motoYear, wheels, motoType);
                    moto.displayInfo();
                    break;

                case 3:
                    System.out.print("Enter make: "); String truckMake = sc.nextLine();
                    System.out.print("Enter model: "); String truckModel = sc.nextLine();
                    System.out.print("Enter year: "); int truckYear = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter cargo capacity (tons): "); double capacity = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter transmission (manual/automatic): "); String transmission = sc.nextLine();
                    Truck truck = new Truck(truckMake, truckModel, truckYear, capacity, transmission);
                    truck.displayInfo();
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        sc.close();
    }
}
