import java.util.Scanner;

public class Unitconverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Unit Converter!");
        System.out.println("Choose the type of conversion:");
        System.out.println("1. Length");
        System.out.println("2. Weight");
        System.out.println("3. Temperature");
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                convertLength(scanner);
                break;
            case 2:
                convertWeight(scanner);
                break;
            case 3:
                convertTemperature(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public static void convertLength(Scanner scanner) {
        System.out.println("Choose the length unit to convert from:");
        System.out.println("1. Meters to Kilometers");
        System.out.println("2. Kilometers to Meters");
        System.out.println("3. Miles to Kilometers");
        System.out.println("4. Kilometers to Miles");

        int choice = scanner.nextInt();
        double input, result;

        System.out.println("Enter the value to convert:");
        input = scanner.nextDouble();

        switch (choice) {
            case 1:
                result = input / 1000;
                System.out.println(input + " Meters = " + result + " Kilometers");
                break;
            case 2:
                result = input * 1000;
                System.out.println(input + " Kilometers = " + result + " Meters");
                break;
            case 3:
                result = input * 1.60934;
                System.out.println(input + " Miles = " + result + " Kilometers");
                break;
            case 4:
                result = input / 1.60934;
                System.out.println(input + " Kilometers = " + result + " Miles");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void convertWeight(Scanner scanner) {
        System.out.println("Choose the weight unit to convert from:");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");

        int choice = scanner.nextInt();
        double input, result;

        System.out.println("Enter the value to convert:");
        input = scanner.nextDouble();

        switch (choice) {
            case 1:
                result = input * 2.20462;
                System.out.println(input + " Kilograms = " + result + " Pounds");
                break;
            case 2:
                result = input / 2.20462;
                System.out.println(input + " Pounds = " + result + " Kilograms");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void convertTemperature(Scanner scanner) {
        System.out.println("Choose the temperature unit to convert from:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");

        int choice = scanner.nextInt();
        double input, result;

        System.out.println("Enter the value to convert:");
        input = scanner.nextDouble();

        switch (choice) {
            case 1:
                result = (input * 9 / 5) + 32;
                System.out.println(input + " Celsius = " + result + " Fahrenheit");
                break;
            case 2:
                result = (input - 32) * 5 / 9;
                System.out.println(input + " Fahrenheit = " + result + " Celsius");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
