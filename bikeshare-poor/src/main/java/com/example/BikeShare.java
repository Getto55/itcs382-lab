package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BikeShare {
    
    // Shared data in public static fields
    public static int libraryBikes = 2;
    public static int canteenBikes = 2;
    public static int dormBikes = 2;
    
    // Int code map: 1 = student, 2 = staff
    public static Map<String, Integer> activeRentals = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Commands:");
        System.out.println("rent <memberID> <type: 1=student, 2=staff> <station>");
        System.out.println("return <memberID> <station> <minutes>");
        System.out.println("quit");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            
            String[] parts = line.split(" ");
            try {
                if (parts[0].equalsIgnoreCase("rent") && parts.length == 4) {
                    processBikeTransaction(true, parts[1], Integer.parseInt(parts[2]), parts[3], 0);
                } else if (parts[0].equalsIgnoreCase("return") && parts.length == 4) {
                    processBikeTransaction(false, parts[1], 0, parts[2], Integer.parseInt(parts[3]));
                } else {
                    System.out.println("Invalid command format.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please provide valid numbers for type and minutes.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // A single method whose entire purpose changes based on the boolean flag
    public static void processBikeTransaction(boolean isRenting, String memberId, int memberType, String station, int minutes) {
        if (isRenting) {
            boolean success = false;
            if (station.equalsIgnoreCase("Library") && libraryBikes > 0) {
                libraryBikes--; success = true;
            } else if (station.equalsIgnoreCase("Canteen") && canteenBikes > 0) {
                canteenBikes--; success = true;
            } else if (station.equalsIgnoreCase("Dorm") && dormBikes > 0) {
                dormBikes--; success = true;
            }

            if (success) {
                activeRentals.put(memberId, memberType);
                System.out.println("Bike rented successfully at " + station);
            } else {
                System.out.println("Failed to rent: No bikes available at " + station + " or invalid station.");
            }
        } else {
            if (!activeRentals.containsKey(memberId)) {
                System.out.println("Error: Member " + memberId + " does not have an active rental.");
                return;
            }
            
            if (station.equalsIgnoreCase("Library")) {
                libraryBikes++;
            } else if (station.equalsIgnoreCase("Canteen")) {
                canteenBikes++;
            } else if (station.equalsIgnoreCase("Dorm")) {
                dormBikes++;
            } else {
                System.out.println("Invalid return station.");
                return;
            }

            int type = activeRentals.remove(memberId);
            int fee = (type == 1) ? minutes * 2 : minutes * 3;
            
            System.out.println("Receipt:");
            System.out.println("Bike returned at: " + station);
            System.out.println("Ride time: " + minutes + " minutes");
            System.out.println("Total Fee: " + fee + " baht");

            try (FileWriter fw = new FileWriter("rides.csv", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println(memberId + "," + station + "," + minutes + "," + fee);
            } catch (IOException e) {
                System.out.println("Error saving to file: " + e.getMessage());
            }
        }
    }
}