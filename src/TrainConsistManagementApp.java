import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Maximum allowed weight per goods bogie (in tonnes)
    static final double MAX_WEIGHT_TONNES = 25.0;

    // Inner GoodsBogie class
    static class GoodsBogie {
        String bogieId;
        String cargoType;
        double weightTonnes;
        boolean isHazardous;

        GoodsBogie(String bogieId, String cargoType, double weightTonnes, boolean isHazardous) {
            this.bogieId = bogieId;
            this.cargoType = cargoType;
            this.weightTonnes = weightTonnes;
            this.isHazardous = isHazardous;
        }

        boolean isCompliant() {
            // Rule 1: Weight must not exceed maximum limit
            if (weightTonnes > MAX_WEIGHT_TONNES) {
                return false;
            }
            // Rule 2: Hazardous materials must be under 20 tonnes
            if (isHazardous && weightTonnes > 20.0) {
                return false;
            }
            return true;
        }

        String getViolationReason() {
            if (weightTonnes > MAX_WEIGHT_TONNES) {
                return "Exceeds max weight limit (" + weightTonnes + "t > " + MAX_WEIGHT_TONNES + "t)";
            }
            if (isHazardous && weightTonnes > 20.0) {
                return "Hazardous cargo exceeds 20t limit (" + weightTonnes + "t)";
            }
            return "None";
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("==================================================\n");

        // Create list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("G01", "Coal", 22.5, false));
        bogies.add(new GoodsBogie("G02", "Chemicals", 18.0, true));
        bogies.add(new GoodsBogie("G03", "Iron Ore", 27.0, false));
        bogies.add(new GoodsBogie("G04", "Petroleum", 21.5, true));
        bogies.add(new GoodsBogie("G05", "Grain", 15.0, false));
        bogies.add(new GoodsBogie("G06", "Explosives", 23.0, true));

        // Display all bogies
        System.out.println("All Goods Bogies:");
        for (GoodsBogie b : bogies) {
            String hazLabel = b.isHazardous ? " [HAZARDOUS]" : "";
            System.out.println("  " + b.bogieId + " - " + b.cargoType + " (" + b.weightTonnes + "t)" + hazLabel);
        }

        // Perform safety compliance check
        System.out.println("\n── Safety Compliance Report ──\n");

        List<GoodsBogie> nonCompliant = bogies.stream()
                .filter(b -> !b.isCompliant())
                .collect(Collectors.toList());

        List<GoodsBogie> compliant = bogies.stream()
                .filter(GoodsBogie::isCompliant)
                .collect(Collectors.toList());

        System.out.println("✓ Compliant Bogies (" + compliant.size() + "):");
        for (GoodsBogie b : compliant) {
            System.out.println("    " + b.bogieId + " - " + b.cargoType + " (" + b.weightTonnes + "t) → PASS");
        }

        System.out.println("\n✗ Non-Compliant Bogies (" + nonCompliant.size() + "):");
        for (GoodsBogie b : nonCompliant) {
            System.out.println("    " + b.bogieId + " - " + b.cargoType + " → FAIL: " + b.getViolationReason());
        }

        System.out.println("\n──────────────────────────────────");
        System.out.println("Total: " + bogies.size() + " | Compliant: " + compliant.size() + " | Violations: " + nonCompliant.size());
        System.out.println("──────────────────────────────────");

        System.out.println("\nProgram continues...");
    }
}