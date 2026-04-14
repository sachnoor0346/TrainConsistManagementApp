import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // 1. Bogie Found
    @Test
    void testSearch_BogieFound() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieSearch.searchBogie(bogieIds, "BG309");

        assertTrue(result);
    }

    // 2. Bogie Not Found
    @Test
    void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieSearch.searchBogie(bogieIds, "BG999");

        assertFalse(result);
    }

    // 3. First Element Match
    @Test
    void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieSearch.searchBogie(bogieIds, "BG101");

        assertTrue(result);
    }

    // 4. Last Element Match
    @Test
    void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = BogieSearch.searchBogie(bogieIds, "BG550");

        assertTrue(result);
    }

    // 5. Single Element Array
    @Test
    void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};

        boolean result = BogieSearch.searchBogie(bogieIds, "BG101");

        assertTrue(result);
    }
}
