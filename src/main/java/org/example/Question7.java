package org.example;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Siew Ya Huai
 *  Class Group: SD2b
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        double totalGains = 0;

        Queue<Share> tracker = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        String command;
        do {
            System.out.print("Please enter command(e.g. buy, sell or quit): ");
            command = in.next();
            if(command.equalsIgnoreCase("buy")){
                try {
                    System.out.println("Enter buy quantity: ");
                    int qty = in.nextInt();
                    System.out.println("Enter price: ");
                    double price = in.nextDouble();
                    //add the trade to a share object
                    tracker.add(new Share(qty, price));
                    System.out.println("Bought " + qty + " shares at $" + String.format("%.2f",price) + " per share");
                }catch (InputMismatchException e){
                    System.out.println("Invalid input, please enter a valid number!");
                    in.next();
                }

            } else if(command.equals("sell")) {
                try {
                    System.out.println("Enter sell quantity: ");
                    int qty = in.nextInt();
                    int totalBuyQuantity = in.nextInt();
                    for (Share share : tracker) {
                        totalBuyQuantity += share.getQuantity();
                    }
                    //if sell quantity exceeds total buy quantity
                    if (qty > totalBuyQuantity) {
                        System.out.println("Error: Cannot sell " + qty + "shares. Only " + totalBuyQuantity + " shares available.");
                        continue;
                    }
                    System.out.println("Enter price: ");
                    double price = in.nextDouble();

                    while (qty > 0 && !tracker.isEmpty()) {
                        Share firstShare = tracker.poll();
                        //if buy quantity of price times quantity times maximum of buy quantity
                        if(firstShare.getQuantity() <= qty) {
                            // get the difference of price times quantity times the maximum of buy quantity
                            totalGains += (price - firstShare.getPrice()) * firstShare.getQuantity();
                            //deduct sell quantity from the buy quantity
                            qty -= firstShare.getQuantity();

                        }else {
                            totalGains += (price - firstShare.getPrice()) * qty;
                            firstShare.setQuantity(firstShare.getQuantity() - qty);
                            tracker.add(firstShare);
                            // exit the loop because sell order is completed
                            qty = 0;
                        }
                    }
                System.out.println("Total gains: $" + totalGains);

            } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter a valid number!");
                    in.next();
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
        in.close();
    }
}