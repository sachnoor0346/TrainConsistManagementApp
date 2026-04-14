import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // 1. Basic alphabetical sorting
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        BogieNameSorter.sortBogieNames(input);

        assertArrayEquals(expected, input);
    }

    // 2. Unsorted input
    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        BogieNameSorter.sortBogieNames(input);

        assertArrayEquals(expected, input);
    }

    // 3. Already sorted array
    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        BogieNameSorter.sortBogieNames(input);

        assertArrayEquals(expected, input);
    }

    // 4. Duplicate bogie names
    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        BogieNameSorter.sortBogieNames(input);

        assertArrayEquals(expected, input);
    }

    // 5. Single element array
    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        BogieNameSorter.sortBogieNames(input);

        assertArrayEquals(expected, input);
    }
}
