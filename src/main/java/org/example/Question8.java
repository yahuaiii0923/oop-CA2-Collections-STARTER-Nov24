package org.example;

import java.util.*;
/**
 *  Name:Siew Ya Huai
 *  Class Group:SD2b
 */
public class Question8  // Multi-company (Queue)
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {
        double totalGains = 0;

        Scanner in = new Scanner(System.in);
        String command;

        Map<String, Queue<Block>> companyShares = new HashMap<>();
        do {
            System.out.print("Please enter command(e.g. buy, sell or quit): ");
            command = in.next();
            if(command.equalsIgnoreCase("buy")) {
                try {
                    System.out.println("Enter company symbol (e.g. AAPL): ");
                    String company = in.next();
                    System.out.println("Enter quantity: ");
                    int qty = in.nextInt();
                    System.out.println("Enter price: ");
                    double price = in.nextDouble();
                    // Code to buy shares here
                    Queue<Block> companyQueue = companyShares.getOrDefault(company, new LinkedList<>());
                    companyQueue.add(new Block(qty, price));
                    //add company and the block object
                    companyShares.put(company, companyQueue);

                    System.out.println("Company " + company + " is bought " + qty + " shares at $" + String.format("%.2f", price) + " per share.");
                } catch (InputMismatchException e){
                    System.out.println("Invalid input, please enter a valid number!");
                    in.next();
                }
            }
            else if(command.equals("sell")){
                try{
                    System.out.println("Enter company symbol (e.g. AAPL): ");
                    String company = in.next().toUpperCase();
                    //Check if company exists in our records
                    if (!companyShares.containsKey(company)){
                        System.out.println("Error: No shares found for company " + company);
                        continue;
                    }
                    System.out.println("Enter quantity: ");
                    int qty = in.nextInt();

                    //Calculate the total shares for this company
                    Queue<Block> companyQueue = companyShares.get(company);
                    int totalBuyQuantity = 0;
                    for (Block block : companyQueue){
                        totalBuyQuantity += block.qty;
                    }
                    //if sell quantity exceeds total buy quantity
                    if (qty > totalBuyQuantity){
                        System.out.println("Error: Cannot sell company " + company + " for " + qty + " share. Only " + totalBuyQuantity + " shares available.");
                        continue;
                    }
                    System.out.println("Enter price: ");
                    double price = in.nextDouble();

                    Queue<Block> updatedQueue = new LinkedList<>();

                    while (qty > 0 && !companyQueue.isEmpty()){
                        Block firstBlock = companyQueue.poll();
                        //if buy quantity less than or equal to sell quantity
                        if (firstBlock.qty <= qty){
                            // get the difference of price times quantity times the maximum of buy quantity
                            totalGains += (price - firstBlock.price) * firstBlock.qty;
                            // deduct sell quantity from the buy quantity
                            qty -= firstBlock.qty;
                        } else {
                            totalGains += (price - firstBlock.price) * qty;
                            firstBlock.qty -= qty;
                            updatedQueue.add(firstBlock);
                            // exit the loop because sell order is completed
                            qty = 0;
                        }
                    }
                    // Code to sell shares and calculate profit here
                    // Add any remaining blocks back to the queue
                    while (!companyQueue.isEmpty()) {
                        updatedQueue.add(companyQueue.poll());
                    }
                    // Update the company's queue
                    if (!updatedQueue.isEmpty()) {
                        companyShares.put(company, updatedQueue);
                    } else {
                        companyShares.remove(company);
                    }
                    System.out.println("Total gains: $" + totalGains);

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please try again!");
                    in.next();
                }
            }
        }while(!command.equalsIgnoreCase("quit"));
        in.close();
    }
}
