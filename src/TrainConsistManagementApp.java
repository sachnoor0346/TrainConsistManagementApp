import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create HashSet for unique bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Add bogie IDs (including duplicates)
        bogieIDs.add("B101");
        bogieIDs.add("B102");
        bogieIDs.add("B103");
        bogieIDs.add("B102"); // Duplicate
        bogieIDs.add("B101"); // Duplicate

        // Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs in Train:");
        System.out.println(bogieIDs);

        System.out.println("\nProgram continues...");
    }
}