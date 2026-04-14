import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // Inner Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" UC10 - Count Total Seats in Train (reduce) ");
        System.out.println("==================================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper-S1", 72));
        bogies.add(new Bogie("AC Chair-A1", 60));
        bogies.add(new Bogie("First Class-F1", 24));
        bogies.add(new Bogie("Second Sitting-D1", 90));
        bogies.add(new Bogie("Third AC-B1", 64));
        bogies.add(new Bogie("Sleeper-S2", 72));

        // Display all bogies and their capacities
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println("  " + b.name + " → Capacity: " + b.capacity);
        }

        // Use Stream reduce() to calculate total seats
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\n──────────────────────────────────");
        System.out.println("Total Seats in Train: " + totalSeats);
        System.out.println("──────────────────────────────────");

        // Alternative: using mapToInt and sum
        int totalSeatsAlt = bogies.stream()
                .mapToInt(b -> b.capacity)
                .sum();

        System.out.println("Total Seats (using mapToInt): " + totalSeatsAlt);

        System.out.println("\nProgram continues...");
    }
}