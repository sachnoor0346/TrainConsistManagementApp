import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // 1. Exception when searching empty bogie list
    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        TrainConsistManagementApp train = new TrainConsistManagementApp();

        assertThrows(IllegalStateException.class, () -> {
            train.findBogie("BG101");
        });
    }

    // 2. Search allowed when data exists
    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        TrainConsistManagementApp train = new TrainConsistManagementApp();
        train.addBogie("BG101");
        train.addBogie("BG205");

        assertDoesNotThrow(() -> {
            train.findBogie("BG101");
        });
    }

    // 3. Bogie found after validation
    @Test
    void testSearch_BogieFoundAfterValidation() {
        TrainConsistManagementApp train = new TrainConsistManagementApp();
        train.addBogie("BG101");
        train.addBogie("BG205");
        train.addBogie("BG309");

        String result = train.findBogie("BG205");

        assertNotNull(result);
        assertEquals("BG205", result);
    }

    // 4. Bogie not found after validation
    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        TrainConsistManagementApp train = new TrainConsistManagementApp();
        train.addBogie("BG101");
        train.addBogie("BG205");
        train.addBogie("BG309");

        String result = train.findBogie("BG999");

        assertNull(result);
    }

    // 5. Single element valid case
    @Test
    void testSearch_SingleElementValidCase() {
        TrainConsistManagementApp train = new TrainConsistManagementApp();
        train.addBogie("BG101");

        String result = train.findBogie("BG101");

        assertNotNull(result);
        assertEquals("BG101", result);
    }
}
