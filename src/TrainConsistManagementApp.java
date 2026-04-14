import java.util.Arrays;

// UC17: Sort Bogie Names using Arrays.sort()
class BogieNameSorter {

    public static void sortBogieNames(String[] bogieNames) {
        // Built-in sorting
        Arrays.sort(bogieNames);
    }

    public static void display(String[] bogieNames) {
        System.out.println(Arrays.toString(bogieNames));
    }
}

// Main Application
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Sample bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        BogieNameSorter.display(bogieNames);

        // Sorting using Arrays.sort()
        BogieNameSorter.sortBogieNames(bogieNames);

        System.out.println("After Sorting:");
        BogieNameSorter.display(bogieNames);

        System.out.println("\nProgram continues after sorting...");
    }
}