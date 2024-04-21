// Eddie Hart
// April 21st, 2024
// CSC 1060

// importing a bunch of shit
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialized variables for later on
        double subTotal = 0;
        double tax = 0;
        double gTotal = 0;
        ArrayList<Double> receipt = new ArrayList<>();

        // try block for reading the items.txt file and adding the items to the receipt arraylist
        // it also calculates the tax and grand total
        try {
            File items = new File("items.txt");
            Scanner reader = new Scanner(items);
            while (reader.hasNextDouble()) {
                receipt.add(reader.nextDouble());
            }
            for (int i = 0; i < receipt.size(); i++) {
                subTotal += receipt.get(i);
            }
            tax = subTotal * 0.053;
            gTotal = subTotal + tax;
            receipt.add(subTotal);
            receipt.add(tax);
            receipt.add(gTotal);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // try block for writing the receipt arraylist to the total.txt file
        try {
            FileWriter writer = new FileWriter("total.txt");
            for (int i = 0; i < receipt.size(); i++){
                writer.write(String.format("%.2f", receipt.get(i)) + "\n");
            }
            writer.close();
        } catch (IOException e){
            System.out.println("IO EXCEPTION");
        }
    }
}
