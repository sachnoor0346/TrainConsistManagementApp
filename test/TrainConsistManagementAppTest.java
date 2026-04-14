import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Reuse Bogie class
    static class Bogie {
        String name;
        String type;
        int capacity;

        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Helper method for grouping
    Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    // 1️⃣ Bogies grouped by type
    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("S2", "Sleeper", 72)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    // 2️⃣ Multiple bogies in same group
    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = List.of(
                new Bogie("A1", "AC", 60),
                new Bogie("A2", "AC", 60),
                new Bogie("B1", "AC", 64)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertEquals(3, result.get("AC").size());
    }

    // 3️⃣ Different bogie types → different groups
    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("A1", "AC", 60),
                new Bogie("F1", "First Class", 24)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertEquals(3, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC"));
        assertTrue(result.containsKey("First Class"));
    }

    // 4️⃣ Empty bogie list
    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertTrue(result.isEmpty());
    }

    // 5️⃣ Single bogie category
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("S2", "Sleeper", 72)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    // 6️⃣ Map contains correct keys
    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("A1", "AC", 60),
                new Bogie("F1", "First Class", 24)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC"));
        assertTrue(result.containsKey("First Class"));
    }

    // 7️⃣ Group size validation
    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("S2", "Sleeper", 72),
                new Bogie("A1", "AC", 60)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC").size());
    }

    // 8️⃣ Original list unchanged
    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("S1", "Sleeper", 72));
        bogies.add(new Bogie("A1", "AC", 60));

        int originalSize = bogies.size();

        groupBogies(bogies);

        assertEquals(originalSize, bogies.size());
    }
}