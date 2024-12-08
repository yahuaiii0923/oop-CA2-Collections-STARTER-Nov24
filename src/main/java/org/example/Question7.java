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

        Queue<Block> tracker = new LinkedList<>();
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
                    //add the trade to a block object
                    tracker.add(new Block(qty, price));
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
                    for (Block block : tracker) {
                        totalBuyQuantity += block.qty;
                    }
                    //if sell quantity exceeds total buy quantity
                    if (qty > totalBuyQuantity) {
                        System.out.println("Error: Cannot sell " + qty + "share. Only " + totalBuyQuantity + " shares available.");
                        continue;
                    }
                    System.out.println("Enter price: ");
                    double price = in.nextDouble();

                    while (qty > 0 && !tracker.isEmpty()) {
                        Block firstBlock = tracker.poll();
                        //if buy quantity of price times quantity times maximum of buy quantity
                        if(firstBlock.qty <= qty) {
                            // get the difference of price times quantity times the maximum of buy quantity
                            totalGains += (price - firstBlock.price) * firstBlock.qty;
                            //deduct sell quantity from the buy qunatity
                            qty -= firstBlock.qty;

                        }else {
                            totalGains += (price - firstBlock.price) * qty;
                            firstBlock.qty -= qty;
                            tracker.add(firstBlock);
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