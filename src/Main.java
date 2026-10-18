
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    Scanner scan = new Scanner(System.in);
     static void main() {

        Main main = new Main();

        // OPGAVE 1
        System.out.println("OPGAVE 1");
        int number = main.promptNumber("Skriv et tal:");
        System.out.println("Du skrev: " + number);


        // OPGAVE 2
        System.out.println("\nOPGAVE 2");

        Drink drink = new Drink();

        try {
            drink.setPrice(25);
            System.out.println("Pris: " + drink.getPrice());

            drink.setPrice(-10);

        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }


        // OPGAVE 2B
        System.out.println("\nOPGAVE 2B");

        ArrayList<String> items = new ArrayList<>();
        items.add("Cola");
        items.add("Fanta");
        items.add("Vand");

        try {
            System.out.println(main.getItem(items, 1));
            System.out.println(main.getItem(items, 5));

        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }


        // OPGAVE 3 OG 3B
        System.out.println("\nOPGAVE 3 OG 3B");

        try {
            ArrayList<String> lines = main.readLines("drinks.txt");

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fejl: Filen blev ikke fundet");
        }

        // Test med en fil der ikke findes
        try {
            main.readLines("findesikke.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Fejl: Filen blev ikke fundet");
        }


        // OPGAVE 4 OG 5
        System.out.println("\nOPGAVE 4 OG 5");

        ArrayList<String> data = new ArrayList<>();

        data.add("Espresso, En kraftfuld og koncentreret kaffe, 25.0");
        data.add("Latte, Espresso med dampet mælk, 45.0");
        data.add("Cola, Kold og brusende, 30.0");
        data.add("Vand, Stille kildevand, gratis");

        double totalPrice = 0;

        for (String line : data) {

            String[] parts = line.split(",");

            String name = parts[0].trim();
            String description = parts[1].trim();
            String priceText = parts[2].trim();

            try {
                double price = Double.parseDouble(priceText);

                System.out.println(name + " - " + description
                        + " (" + price + " kr)");

                totalPrice += price;

            } catch (NumberFormatException e) {
                System.out.println("Fejl: Prisen på "
                        + name + " er ikke et tal");
            }
        }

        System.out.println("Samlet pris: " + totalPrice + " kr");
    }


    // OPGAVE 1 - REKURSION
    public int promptNumber(String msg) {

        System.out.println(msg);

        try {
            return Integer.parseInt(scan.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Fejl: Du skal skrive et tal");
            return promptNumber(msg);
        }
    }


    // OPGAVE 2B - UGYLDIGT INDEKS
    public String getItem(ArrayList<String> items, int index) {

        if (index < 0 || index >= items.size()) {
            throw new IllegalArgumentException(
                    "Gyldigt indeks er 0 til " + (items.size() - 1));
        }

        return items.get(index);
    }


    // OPGAVE 3 OG 3B - THROWS
    public ArrayList<String> readLines(String path)
            throws FileNotFoundException {

        ArrayList<String> lines = new ArrayList<>();

        Scanner fileScan = new Scanner(new File(path));

        while (fileScan.hasNextLine()) {
            lines.add(fileScan.nextLine());
        }

        fileScan.close();

        return lines;
    }
}
