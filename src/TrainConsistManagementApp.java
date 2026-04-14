import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // Custom Exception for invalid bogie capacity
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Inner Bogie class with validation
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                        "Invalid capacity (" + capacity + ") for bogie '" + name + "': capacity must be positive."
                );
            }
            if (capacity > 150) {
                throw new InvalidCapacityException(
                        "Invalid capacity (" + capacity + ") for bogie '" + name + "': exceeds maximum limit of 150."
                );
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("==================================================\n");

        // Test data: mix of valid and invalid capacities
        String[] names = {"Sleeper-S1", "AC Chair-A1", "General-G1", "First Class-F1", "Invalid-X1", "Overflow-O1"};
        int[] capacities = {72, 60, 90, 24, -5, 200};

        List<Bogie> validBogies = new ArrayList<>();
        int errorCount = 0;

        System.out.println("Processing Bogie Entries:\n");

        for (int i = 0; i < names.length; i++) {
            try {
                System.out.println("  Attempting to create: " + names[i] + " (capacity: " + capacities[i] + ")");
                Bogie bogie = new Bogie(names[i], capacities[i]);
                validBogies.add(bogie);
                System.out.println("    → ✓ Created successfully\n");
            } catch (InvalidCapacityException e) {
                System.out.println("    → ✗ ERROR: " + e.getMessage() + "\n");
                errorCount++;
            } finally {
                // Finally block always executes
            }
        }

        // Display summary
        System.out.println("── Processing Summary ──\n");
        System.out.println("  Total entries processed: " + names.length);
        System.out.println("  Successfully created:    " + validBogies.size());
        System.out.println("  Errors encountered:      " + errorCount);

        System.out.println("\nValid Bogies:");
        for (Bogie b : validBogies) {
            System.out.println("  " + b.name + " → Capacity: " + b.capacity);
        }

        // Demonstrate NumberFormatException handling
        System.out.println("\n── Parsing Test ──\n");
        String[] rawInputs = {"72", "abc", "60", "null", "24"};
        for (String input : rawInputs) {
            try {
                int parsed = Integer.parseInt(input);
                System.out.println("  Parsed '" + input + "' → " + parsed + " ✓");
            } catch (NumberFormatException e) {
                System.out.println("  Parsed '" + input + "' → ERROR: Not a valid number ✗");
            }
        }

        System.out.println("\nProgram continues...");
    }
}