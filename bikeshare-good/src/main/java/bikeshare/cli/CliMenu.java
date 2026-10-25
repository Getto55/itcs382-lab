package bikeshare.cli;

import bikeshare.model.MemberType;
import bikeshare.model.Receipt;
import bikeshare.model.Station;
import bikeshare.service.BikeShareService;

import java.util.Scanner;

public class CliMenu {
    private final BikeShareService service;

    public CliMenu(BikeShareService service) {
        this.service = service;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to BikeShare!");
            System.out.println("Commands:");
            System.out.println("  rent <memberId> <STUDENT|STAFF> <LIBRARY|CANTEEN|DORM>");
            System.out.println("  return <memberId> <LIBRARY|CANTEEN|DORM> <minutes>");
            System.out.println("  quit");

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                processCommand(input);
            }
        }
    }

    private void processCommand(String input) {
        String[] parts = input.split("\\s+");
        if (parts.length == 0 || parts[0].isEmpty()) return;

        try {
            String command = parts[0].toLowerCase();
            switch (command) {
                case "rent" -> handleRent(parts);
                case "return" -> handleReturn(parts);
                default -> System.out.println("Unknown command.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleRent(String[] parts) {
        if (parts.length != 4) {
            System.out.println("Usage: rent <memberId> <STUDENT|STAFF> <LIBRARY|CANTEEN|DORM>");
            return;
        }
        String memberId = parts[1];
        MemberType type = MemberType.valueOf(parts[2].toUpperCase());
        Station station = Station.valueOf(parts[3].toUpperCase());

        service.rentBike(memberId, type, station);
        System.out.println("Bike rented successfully to " + memberId + ".");
    }

    private void handleReturn(String[] parts) {
        if (parts.length != 4) {
            System.out.println("Usage: return <memberId> <LIBRARY|CANTEEN|DORM> <minutes>");
            return;
        }
        String memberId = parts[1];
        Station station = Station.valueOf(parts[2].toUpperCase());
        int minutes = Integer.parseInt(parts[3]);

        Receipt receipt = service.returnBike(memberId, station, minutes);
        printReceipt(receipt);
    }

    private void printReceipt(Receipt receipt) {
        System.out.println("=== RECEIPT ===");
        System.out.println("Bike ID : " + receipt.bikeId());
        System.out.println("Minutes : " + receipt.minutes());
        System.out.println("Fee     : " + receipt.fee() + " baht");
        System.out.println("===============");
    }
}