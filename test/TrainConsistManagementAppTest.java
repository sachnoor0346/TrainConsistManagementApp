import org.junit.jupiter.api.Test;
import java.util.*;
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

    // Helper: Loop filtering
    List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Helper: Stream filtering
    List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    // Loop filtering logic
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 72),
                new Bogie("A1", 60),
                new Bogie("D1", 90)
        );

        List<Bogie> result = filterUsingLoop(bogies);

        assertEquals(2, result.size()); // 72 & 90
    }

    // Stream filtering logic
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 72),
                new Bogie("A1", 60),
                new Bogie("D1", 90)
        );

        List<Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
    }

    // Loop and Stream results match
    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = List.of(
                new Bogie("S1", 72),
                new Bogie("A1", 60),
                new Bogie("D1", 90)
        );

        List<Bogie> loopResult = filterUsingLoop(bogies);
        List<Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    // Execution time measurement
    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("B" + i, i % 100));
        }

        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    // Large dataset processing
    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("B" + i, (i % 2 == 0) ? 70 : 50));
        }

        List<Bogie> result = filterUsingStream(bogies);

        // Half should be > 60 (i.e., 70)
        assertEquals(50000, result.size());
    }
}
