// UC18: Linear Search for Bogie ID

class BogieSearch {

    // Linear Search Method
    public static boolean searchBogie(String[] bogieIds, String key) {

        // Traverse array sequentially
        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Match found → stop early
            }
        }

        return false; // No match found after full traversal
    }

    // Display result
    public static void displayResult(String key, boolean found) {
        if (found) {
            System.out.println("Bogie ID " + key + " FOUND in the consist.");
        } else {
            System.out.println("Bogie ID " + key + " NOT FOUND in the consist.");
        }
    }
}

// Main Application
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Sample bogie IDs (unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Test Cases

        System.out.println("---- Linear Search Tests ----");

        // 1. Bogie Found
        String key1 = "BG309";
        BogieSearch.displayResult(key1, BogieSearch.searchBogie(bogieIds, key1));

        // 2. Bogie Not Found
        String key2 = "BG999";
        BogieSearch.displayResult(key2, BogieSearch.searchBogie(bogieIds, key2));

        // 3. First Element Match
        String key3 = "BG101";
        BogieSearch.displayResult(key3, BogieSearch.searchBogie(bogieIds, key3));

        // 4. Last Element Match
        String key4 = "BG550";
        BogieSearch.displayResult(key4, BogieSearch.searchBogie(bogieIds, key4));

        // 5. Single Element Array
        String[] single = {"BG101"};
        String key5 = "BG101";
        BogieSearch.displayResult(key5, BogieSearch.searchBogie(single, key5));

        System.out.println("\nProgram continues after search...");
    }
}