import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Train Consist Management App - UC20
public class TrainConsistManagementApp {

    // Inner Bogie class with type attribute
    static class Bogie {
        String name;
        String type;
        int capacity;

        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }

        return null; // Not found
    }

    // Main method
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("==================================================\n");

        // Create list of passenger bogies with types
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("S1", "Sleeper", 72));
        bogies.add(new Bogie("A1", "AC", 60));
        bogies.add(new Bogie("S2", "Sleeper", 72));
        bogies.add(new Bogie("B1", "AC", 64));
        bogies.add(new Bogie("F1", "First Class", 24));
        bogies.add(new Bogie("S3", "Sleeper", 72));
        bogies.add(new Bogie("A2", "AC", 60));

        // Display all bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println("  " + b.name + " [" + b.type + "] → Capacity: " + b.capacity);
        }

        // Group bogies by type using Collectors.groupingBy()
        Map<String, List<Bogie>> groupedByType = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // Display grouped bogies
        System.out.println("\nBogies Grouped by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedByType.entrySet()) {
            System.out.println("\n  Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("    - " + b.name + " → Capacity: " + b.capacity);
            }
        }

        System.out.println("\nProgram continues after handling exceptions...");
    }
}