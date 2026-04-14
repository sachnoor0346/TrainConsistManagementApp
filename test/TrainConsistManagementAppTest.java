import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

    // Reuse Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Helper method for reduce
    int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // 1️⃣ Total seat calculation
    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 72),
                new Bogie("A1", 60)
        );

        int result = calculateTotalSeats(bogies);

        assertEquals(132, result);
    }

    // 2️⃣ Multiple bogies aggregation
    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 72),
                new Bogie("A1", 60),
                new Bogie("F1", 24)
        );

        int result = calculateTotalSeats(bogies);

        assertEquals(156, result);
    }

    // 3️⃣ Single bogie
    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 72)
        );

        int result = calculateTotalSeats(bogies);

        assertEquals(72, result);
    }

    // 4️⃣ Empty list
    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int result = calculateTotalSeats(bogies);

        assertEquals(0, result);
    }

    // 5️⃣ Correct capacity extraction
    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 70),
                new Bogie("A1", 30)
        );

        int result = calculateTotalSeats(bogies);

        assertEquals(100, result);
    }

    // 6️⃣ All bogies included
    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 10),
                new Bogie("S2", 20),
                new Bogie("S3", 30)
        );

        int result = calculateTotalSeats(bogies);

        assertEquals(60, result);
    }

    // 7️⃣ Original list unchanged
    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("S1", 72));
        bogies.add(new Bogie("A1", 60));

        int originalSize = bogies.size();

        calculateTotalSeats(bogies);

        assertEquals(originalSize, bogies.size());
    }
}
