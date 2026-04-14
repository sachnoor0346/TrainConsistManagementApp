import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create HashMap
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert data
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);

        // BEFORE SORTING
        System.out.println("\nBefore Sorting:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
        }

        // SORTING using TreeMap (sorts by key automatically)
        Map<String, Integer> sortedMap = new TreeMap<>(bogieCapacityMap);

        // AFTER SORTING
        System.out.println("\nAfter Sorting (by Bogie Type):");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
        }

        System.out.println("\nProgram continues...");
    }
}