import java.util.ArrayList;
import java.util.List;

// Train Consist Management App - UC20
public class TrainConsistManagementApp {

    // Collection of bogies
    private List<String> bogies = new ArrayList<>();

    // Method to add bogies
    public void addBogie(String bogieId) {
        bogies.add(bogieId);
        System.out.println("Bogie " + bogieId + " added to train.");
    }

    /**
     * UC20: Exception Handling During Search Operations
     * Implements fail-fast validation
     */
    public String findBogie(String bogieId) {

        // State Validation (Fail-Fast)
        if (bogies.isEmpty()) {
            throw new IllegalStateException(
                    "Search failed: No bogies available in the train. Please add bogies first."
            );
        }

        // Search Logic
        for (String bogie : bogies) {
            if (bogie.equals(bogieId)) {
                return bogie;
            }
        }

        return null; // Not found
    }

    // Main method
    public static void main(String[] args) {

        TrainConsistManagementApp train = new TrainConsistManagementApp();

        System.out.println("===== UC20: Exception Handling During Search =====\n");

        // Case 1: Search without adding bogies (FAIL-FAST)
        try {
            System.out.println("Attempting search in empty train...");
            train.findBogie("BG101"); // should throw exception
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Add bogies
        System.out.println("\nAdding bogies...\n");
        train.addBogie("BG101");
        train.addBogie("BG205");
        train.addBogie("BG309");

        // Case 2: Valid search
        try {
            System.out.println("\nSearching for BG205...");
            String result = train.findBogie("BG205");

            if (result != null) {
                System.out.println("Bogie FOUND: " + result);
            } else {
                System.out.println("Bogie NOT FOUND");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Case 3: Bogie not found
        try {
            System.out.println("\nSearching for BG999...");
            String result = train.findBogie("BG999");

            if (result != null) {
                System.out.println("Bogie FOUND: " + result);
            } else {
                System.out.println("Bogie NOT FOUND");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nProgram continues after handling exceptions...");
    }
}