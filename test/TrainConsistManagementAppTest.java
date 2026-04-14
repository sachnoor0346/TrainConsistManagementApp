import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TrainConsistManagementAppTest {

    // 1. Safe cargo assignment
    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie cylBogie = new CylindricalBogie("CB1");

        assertDoesNotThrow(() -> {
            cylBogie.assignCargo(CargoType.PETROLEUM);
        });

        
        assertEquals(CargoType.PETROLEUM, cylBogie.getCargo());
    }

    // 2. Unsafe assignment handled (exception caught internally)
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie rectBogie = new RectangularBogie("RB1");

        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        rectBogie.assignCargo(CargoType.PETROLEUM);

        String result = output.toString();

        assertTrue(result.contains("ERROR: Unsafe cargo! Petroleum cannot be loaded"));
    }

    // 3. Cargo not assigned after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie rectBogie = new RectangularBogie("RB1");

        rectBogie.assignCargo(CargoType.PETROLEUM);

        assertNull(rectBogie.getCargo());
    }

    // 4. Program continues after exception
    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie rectBogie = new RectangularBogie("RB1");
        GoodsBogie cylBogie = new CylindricalBogie("CB1");

        assertDoesNotThrow(() -> {
            rectBogie.assignCargo(CargoType.PETROLEUM); // unsafe
            cylBogie.assignCargo(CargoType.COAL);       // should still execute
        });

        assertEquals(CargoType.COAL, cylBogie.getCargo());
    }

    // 5. Finally block execution
    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie rectBogie = new RectangularBogie("RB1");

        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        rectBogie.assignCargo(CargoType.PETROLEUM);

        String result = output.toString();

        assertTrue(result.contains("Assignment attempt completed for RB1"));
    }
}
