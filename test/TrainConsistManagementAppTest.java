import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Reuse GoodsBogie class
    static class GoodsBogie {
        String bogieId;
        String cargoType;
        double weightTonnes;
        boolean isHazardous;

        static final double MAX_WEIGHT_TONNES = 25.0;

        GoodsBogie(String bogieId, String cargoType, double weightTonnes, boolean isHazardous) {
            this.bogieId = bogieId;
            this.cargoType = cargoType;
            this.weightTonnes = weightTonnes;
            this.isHazardous = isHazardous;
        }

        boolean isCompliant() {
            if (weightTonnes > MAX_WEIGHT_TONNES) return false;
            if (isHazardous && weightTonnes > 20.0) return false;
            return true;
        }
    }

    // Helper method → overall train safety
    boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(GoodsBogie::isCompliant);
    }

    // 1️⃣ All bogies valid
    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("G1", "Coal", 20, false),
                new GoodsBogie("G2", "Chemicals", 18, true)
        );

        assertTrue(isTrainSafe(bogies));
    }

    // 2️⃣ Bogie exceeds max weight
    @Test
    void testSafety_BogieExceedsMaxWeight() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("G1", "Iron Ore", 30, false) // >25
        );

        assertFalse(isTrainSafe(bogies));
    }

    // 3️⃣ Hazardous cargo exceeds 20 tonnes
    @Test
    void testSafety_HazardousOverLimit() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("G1", "Explosives", 22, true)
        );

        assertFalse(isTrainSafe(bogies));
    }

    // 4️⃣ Non-hazardous allowed under 25
    @Test
    void testSafety_NonHazardousAllowed() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("G1", "Coal", 24, false)
        );

        assertTrue(isTrainSafe(bogies));
    }

    // 5️⃣ Mixed bogies with violation
    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("G1", "Grain", 15, false),
                new GoodsBogie("G2", "Explosives", 23, true) // violation
        );

        assertFalse(isTrainSafe(bogies));
    }

    // 6️⃣ Empty bogie list
    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(isTrainSafe(bogies)); // no violations → safe
    }

    // 7️⃣ Compliance filtering check
    @Test
    void testSafety_FilterCompliantAndNonCompliant() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("G1", "Coal", 20, false),
                new GoodsBogie("G2", "Iron Ore", 30, false)
        );

        List<GoodsBogie> compliant = bogies.stream()
                .filter(GoodsBogie::isCompliant)
                .collect(Collectors.toList());

        List<GoodsBogie> nonCompliant = bogies.stream()
                .filter(b -> !b.isCompliant())
                .collect(Collectors.toList());

        assertEquals(1, compliant.size());
        assertEquals(1, nonCompliant.size());
    }

    // 8️⃣ Original list unchanged
    @Test
    void testSafety_OriginalListUnchanged() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("G1", "Coal", 20, false));

        int originalSize = bogies.size();

        isTrainSafe(bogies);

        assertEquals(originalSize, bogies.size());
    }
}
