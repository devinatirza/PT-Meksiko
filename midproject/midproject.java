import java.util.Scanner;
import java.util.ArrayList;

abstract class Vehicle {
    protected String brand;
    protected String name;
    protected String licensePlate;
    protected int topSpeed;
    protected int gasCap;
    protected int wheel;

    public Vehicle(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel) {
        this.brand = brand;
        this.name = name;
        this.licensePlate = licensePlate;
        this.topSpeed = topSpeed;
        this.gasCap = gasCap;
        this.wheel = wheel;
    }

    public abstract void turnOnEntertainmentSystem();
}

class Car extends Vehicle {
    private int entertainmentSystem;

    public Car(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel, int entertainmentSystem) {
        super(brand, name, licensePlate, topSpeed, gasCap, wheel);
        this.entertainmentSystem = entertainmentSystem;
    }

    public void turnOnEntertainmentSystem() {
        System.out.println("Turning on entertainment system...");
    }
}

class Supercar extends Car {
    public Supercar(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel, int entertainmentSystem) {
        super(brand, name, licensePlate, topSpeed, gasCap, wheel, entertainmentSystem);
    }

    public void turnOnEntertainmentSystem() {
        System.out.println("Turning on entertainment system...");
        System.out.println("Boosting!");
    }
}

class Minivan extends Car {
    public Minivan(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel, int entertainmentSystem) {
        super(brand, name, licensePlate, topSpeed, gasCap, wheel, entertainmentSystem);
    }
}

class Motorcycle extends Vehicle {
    private int helmet;

    public Motorcycle(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel, int helmet) {
        super(brand, name, licensePlate, topSpeed, gasCap, wheel);
        this.helmet = helmet;
    }

    public void turnOnEntertainmentSystem() {
        System.out.println(name + " is standing!");
    }
}

class Automatic extends Motorcycle {
    public Automatic(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel, int helmet) {
        super(brand, name, licensePlate, topSpeed, gasCap, wheel, helmet);
    }
}

class Manual extends Motorcycle {
    public Manual(String brand, String name, String licensePlate, int topSpeed, int gasCap, int wheel, int helmet) {
        super(brand, name, licensePlate, topSpeed, gasCap, wheel, helmet);
    }
}

public class Main {
    static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Input Vehicle");
            System.out.println("2. View Vehicle");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice: ");

            int menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    inputVehicle(in);
                    break;
                case 2:
                    viewVehicle();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Menu");
                    break;
            }
        }

        in.close();
    }

    private static void inputVehicle(Scanner in) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Input type [Car | Motorcycle]: ");
            String type = scan.nextLine();
            if (!type.equals("Car") && !type.equals("Motorcycle")) {
                break;
            }

            System.out.print("Input brand [>= 5]: ");
            String brand = scan.nextLine();
            while (brand.length() < 5) {
                System.out.println("Brand must be at least 5 characters long");
                System.out.print("Input brand [>= 5]: ");
                brand = scan.nextLine();
            }

            System.out.print("Input name [>= 5]: ");
            String name = scan.nextLine();
            while (name.length() < 5) {
                System.out.println("Name must be at least 5 characters long");
                System.out.print("Input name [>= 5]: ");
                name = scan.nextLine();
            }

            System.out.print("Input license: ");
            String license = scan.nextLine();

            System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
            int topSpeed = scan.nextInt();
            while (topSpeed < 100 || topSpeed > 250) {
                System.out.println("Top speed must be between 100 and 250");
                System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
                topSpeed = scan.nextInt();
            }
            scan.nextLine();

            System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
            int gasCap = scan.nextInt();
            while (gasCap < 30 || gasCap > 60) {
                System.out.println("Gas capacity must be between 30 and 60");
                System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
                gasCap = scan.nextInt();
            }
            scan.nextLine();

            System.out.print("Input wheel [4 <= wheel <= 6]: ");
            int wheel = scan.nextInt();
            while (wheel < 4 || wheel > 6) {
                System.out.println("Wheel must be between 4 and 6");
                System.out.print("Input wheel [4 <= wheel <= 6]: ");
                wheel = scan.nextInt();
            }
            scan.nextLine();

            if (type.equals("Car")) {
                System.out.print("Input type [SUV | Supercar | Minivan]: ");
                String carType = scan.nextLine();
                while (!carType.equals("SUV") && !carType.equals("Supercar") && !carType.equals("Minivan")) {
                System.out.println("Type must be either SUV, Supercar, or Minivan");
                System.out.print("Input type [SUV | Supercar | Minivan]: ");
                carType = scan.nextLine();
                }
                System.out.println("Input entertainment system amount [>= 1]: ");
                int entertainmentSystem = scan.nextInt();
                scan.nextLine();

                if (entertainmentSystem < 1) {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }

                vehicles.add(new Car(brand, name, license, topSpeed, gasCap, wheel, carType, entertainmentSystem));
            } else if (type.equalsIgnoreCase("Motorcycle")) {
                System.out.print("Input number of helmets [>= 1]: ");
                int helmet = sc.nextInt();
                Motorcycle motorcycle = new Motorcycle();
                vehicles.add(motorcycle);
            }
        }
    }

    private static void inputVehicle(Scanner in) {
        Scanner scan = new Scanner(System.in);
        int vehicleIndex = 0;
        
        public void printVehicleList(List<Vehicle> vehicles) {
            System.out.println("Vehicle List");
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println((i + 1) + ". " + vehicles.get(i).getBrand() + " " + vehicles.get(i).getName());
            }
        }

        public int getVehicleSelection(List<Vehicle> vehicles) {
            System.out.print("Choose the vehicle (number): ");
            int choice = scan.nextInt() - 1;
            if (choice >= 0 && choice < vehicles.size()) {
                return choice;
            } else {
                System.out.println("Invalid selection. Please try again.");
                return getVehicleSelection(vehicles);
            }
        }

        public void displayVehicleInfo(Vehicle vehicle) {
            System.out.println("Brand: " + vehicle.getBrand());
            System.out.println("Name: " + vehicle.getName());
            System.out.println("License Plate: " + vehicle.getLicense());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Gas Capacity: " + vehicle.getGasCap());
            System.out.println("Top Speed: " + vehicle.getTopSpeed());
            System.out.println("Wheel(s): " + vehicle.getWheel());

            if (vehicles.get(vehicleIndex) instanceof Car) {
                Car car = (Car) vehicles.get(vehicleIndex);
                if (car.getType().equals("Supercar")) {
                    System.out.println("Boosting!");
                } else {
                    System.out.println("Turning on entertainment system...");
                }
            } else if (vehicles.get(vehicleIndex) instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicles.get(vehicleIndex);
                System.out.println(motorcycle.getName() + " is standing!");
                System.out.print("Input price of helmet: ");
                int price = sc.nextInt();
                motorcycle.setHelmetPrice(price);
                System.out.println("Price: " + motorcycle.getHelmetPrice());
            }
        }
    }
}

