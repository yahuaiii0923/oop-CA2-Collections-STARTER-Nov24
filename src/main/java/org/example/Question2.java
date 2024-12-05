package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Cheryl Kong
 *  Class Group: SD2B
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation() {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter commands (e.g., 1 to add car 1, -2 to remove car 2, 0 to stop):");

        while(true) {
            try {
                System.out.println();
                int command = scanner.nextInt();

                if (command == 0) {
                    System.out.println("Simulation ending. Bye!");
                    break;
                } else if (command > 0) {
                    // add car to driveway
                    driveway.push(command);
                    System.out.println("Car " + command + " added to the driveway.");
                } else {
                    if (!driveway.contains(-command)) { // check if car is in the driveway
                        System.out.println("Car " + -command + " is not in the driveway.");
                    } else {
                        // remove cars until we find the one to remove
                        while (!driveway.isEmpty()) {
                            int topCar = driveway.pop(); // remove the top car
                            if (topCar == -command) {
                                System.out.println("Car " + -command + " removed from the driveway.");
                                break;
                            } else {
                                street.push(topCar); // move to the street if it's not the car to remove
                            }
                        }

                        // move the cars on the street back to the driveway
                        while (!street.isEmpty()) {
                            driveway.push(street.pop());
                        }
                    }
                }

                System.out.println("Cars in driveway: " + driveway);
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
