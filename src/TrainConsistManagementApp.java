// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Enum for Cargo Types
enum CargoType {
    COAL,
    GRAINS,
    PETROLEUM
}

// Abstract Goods Bogie
abstract class GoodsBogie {
    protected String bogieId;
    protected CargoType cargo;

    public GoodsBogie(String bogieId) {
        this.bogieId = bogieId;
    }

    public abstract String getShape();

    // UC15: Safe cargo assignment using try-catch-finally
    public void assignCargo(CargoType cargoType) {
        try {
            validateCargo(cargoType);
            this.cargo = cargoType;
            System.out.println("Cargo " + cargoType + " assigned to " + bogieId);
        }
        catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            System.out.println("Assignment attempt completed for " + bogieId);
        }
    }

    // Validation logic
    private void validateCargo(CargoType cargoType) {
        if (this.getShape().equalsIgnoreCase("Rectangular")
                && cargoType == CargoType.PETROLEUM) {
            throw new CargoSafetyException(
                    "Unsafe cargo! Petroleum cannot be loaded into a Rectangular Bogie: " + bogieId
            );
        }
    }

    public CargoType getCargo() {
        return cargo;
    }
}

// Rectangular Bogie
class RectangularBogie extends GoodsBogie {
    public RectangularBogie(String bogieId) {
        super(bogieId);
    }

    @Override
    public String getShape() {
        return "Rectangular";
    }
}

// Cylindrical Bogie
class CylindricalBogie extends GoodsBogie {
    public CylindricalBogie(String bogieId) {
        super(bogieId);
    }

    @Override
    public String getShape() {
        return "Cylindrical";
    }
}

// Main Application
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        GoodsBogie rectBogie = new RectangularBogie("RB1");
        GoodsBogie cylBogie = new CylindricalBogie("CB1");

        // Safe assignment
        rectBogie.assignCargo(CargoType.COAL);

        System.out.println();

        // Unsafe assignment (should trigger exception)
        rectBogie.assignCargo(CargoType.PETROLEUM);

        System.out.println();

        // Safe assignment
        cylBogie.assignCargo(CargoType.PETROLEUM);

        System.out.println("\nProgram continues after handling exceptions...");
    }
}