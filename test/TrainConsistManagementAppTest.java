import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class TrainConsistManagementAppTest {

    // 1. Bogie Found
    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG309");

        assertTrue(result);
    }

    // 2. Bogie Not Found
    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG999");

        assertFalse(result);
    }

    // 3. First Element Match
    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG101");

        assertTrue(result);
    }

    // 4. Last Element Match
    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG550");

        assertTrue(result);
    }

    // 5. Single Element Array
    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG101");

        assertTrue(result);
    }

    // 6. Empty Array
    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG101");

        assertFalse(result);
    }

    // 7. Unsorted Input (handled by sorting before search)
    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};

        // IMPORTANT: Binary search requires sorted input
        Arrays.sort(bogieIds);

        boolean result = BogieBinarySearch.binarySearch(bogieIds, "BG205");

        assertTrue(result);
    }
}
