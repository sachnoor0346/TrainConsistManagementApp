import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Reuse Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Helper method for filtering
    List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // 1️⃣ Capacity greater than threshold
    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    // 2️⃣ Capacity equal to threshold (should NOT include)
    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 70));

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 3️⃣ Capacity less than threshold
    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 4️⃣ Multiple bogies matching
    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Second Sitting", 90));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    // 5️⃣ No bogies matching
    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC Chair", 50));
        bogies.add(new Bogie("First Class", 40));

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 6️⃣ All bogies matching
    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("Second Sitting", 90));

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    // 7️⃣ Empty bogie list
    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 8️⃣ Original list unchanged
    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        int originalSize = bogies.size();

        filterBogies(bogies, 70);

        assertEquals(originalSize, bogies.size());
    }
}
