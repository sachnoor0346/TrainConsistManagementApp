import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // 1️⃣ Valid Train ID
    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.validateTrainId("TR12345"));
        assertTrue(TrainConsistManagementApp.validateTrainId("TR00001"));
    }

    // 2️⃣ Invalid Train ID format
    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.validateTrainId("TRAIN12"));
        assertFalse(TrainConsistManagementApp.validateTrainId("TR12A45"));
        assertFalse(TrainConsistManagementApp.validateTrainId("12345TR"));
    }

    // 3️⃣ Valid Cargo Code
    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.validateCargoCode("CGO-ABC12"));
        assertTrue(TrainConsistManagementApp.validateCargoCode("CGO-XYZ99"));
    }

    // 4️⃣ Invalid Cargo Code format
    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("CGO-abc12")); // lowercase
        assertFalse(TrainConsistManagementApp.validateCargoCode("CGO12345"));  // missing format
        assertFalse(TrainConsistManagementApp.validateCargoCode("ABC-CGO12")); // wrong order
    }

    // 5️⃣ Train ID digit length validation
    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagementApp.validateTrainId("TR1234"));   // 4 digits
        assertFalse(TrainConsistManagementApp.validateTrainId("TR123456")); // 6 digits
    }

    // 6️⃣ Cargo Code uppercase validation
    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("CGO-AbC12"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("CGO-abc12"));
    }

    // 7️⃣ Empty input handling
    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagementApp.validateTrainId(""));
        assertFalse(TrainConsistManagementApp.validateCargoCode(""));
    }

    // 8️⃣ Exact pattern match (no extra characters allowed)
    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagementApp.validateTrainId("TR12345X"));
        assertFalse(TrainConsistManagementApp.validateTrainId("XTR12345"));

        assertFalse(TrainConsistManagementApp.validateCargoCode("CGO-ABC12X"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("XCGO-ABC12"));
    }
}