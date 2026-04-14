import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    // Train ID pattern: Must start with "TR" followed by exactly 5 digits
    // Example valid: TR12345, TR00001
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("^TR\\d{5}$");

    // Cargo Code pattern: Must start with "CGO-" followed by 3 uppercase letters and 2 digits
    // Example valid: CGO-ABC12, CGO-XYZ99
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("^CGO-[A-Z]{3}\\d{2}$");

    public static boolean validateTrainId(String trainId) {
        if (trainId == null || trainId.isEmpty()) {
            return false;
        }
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) {
            return false;
        }
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("==================================================\n");

        // Test Train IDs
        String[] trainIds = {"TR12345", "TR00001", "TX12345", "TR1234", "TR123456", "tr12345", ""};

        System.out.println("Train ID Validation:");
        System.out.println("  Pattern: TR followed by exactly 5 digits\n");
        for (String id : trainIds) {
            String displayId = id.isEmpty() ? "(empty)" : id;
            boolean valid = validateTrainId(id);
            System.out.println("  " + displayId + " → " + (valid ? "✓ VALID" : "✗ INVALID"));
        }

        // Test Cargo Codes
        String[] cargoCodes = {"CGO-ABC12", "CGO-XYZ99", "CGO-abc12", "CGO-AB1", "CGO-ABCD12", "CARGO-ABC12", ""};

        System.out.println("\nCargo Code Validation:");
        System.out.println("  Pattern: CGO- followed by 3 uppercase letters and 2 digits\n");
        for (String code : cargoCodes) {
            String displayCode = code.isEmpty() ? "(empty)" : code;
            boolean valid = validateCargoCode(code);
            System.out.println("  " + displayCode + " → " + (valid ? "✓ VALID" : "✗ INVALID"));
        }

        System.out.println("\nProgram continues...");
    }
}