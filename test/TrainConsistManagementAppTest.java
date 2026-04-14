import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // 1. Valid capacity should create object successfully
    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.Bogie bogie =
                    new TrainConsistManagementApp.Bogie("Sleeper-S1", 72);

            assertEquals("Sleeper-S1", bogie.name);
            assertEquals(72, bogie.capacity);
        });
    }

    // 2. Negative capacity should throw exception
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Invalid-X1", -10)
        );

        assertTrue(exception.getMessage().contains("Invalid capacity"));
    }

    // 3. Zero capacity should throw exception
    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Zero-Z1", 0)
        );

        assertTrue(exception.getMessage().contains("capacity must be positive"));
    }

    // 4. Validate exact exception message
    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Invalid-X1", -5)
        );

        assertEquals(
                "Invalid capacity (-5) for bogie 'Invalid-X1': capacity must be positive.",
                exception.getMessage()
        );
    }

    // 5. Object integrity after creation
    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.Bogie bogie =
                new TrainConsistManagementApp.Bogie("AC Chair-A1", 60);

        assertEquals("AC Chair-A1", bogie.name);
        assertEquals(60, bogie.capacity);
    }

    // 6. Multiple valid bogies creation
    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.Bogie b1 =
                    new TrainConsistManagementApp.Bogie("Sleeper-S1", 72);
            TrainConsistManagementApp.Bogie b2 =
                    new TrainConsistManagementApp.Bogie("General-G1", 90);
            TrainConsistManagementApp.Bogie b3 =
                    new TrainConsistManagementApp.Bogie("First Class-F1", 24);

            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}
