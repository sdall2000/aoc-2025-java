package yr2025.day06;

import common.Utilities;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrashCompactorTest {
    @Test
    void part1() throws IOException {
        var lines = Utilities.readResourceLines("/yr2025/day06/input.txt");
        var solution = new TrashCompactor();

        assertEquals(6_503_327_062_445L, solution.part1(lines));
    }

    @Test
    void part2() throws IOException {
        var lines = Utilities.readResourceLines("/yr2025/day06/input.txt");
        var solution = new TrashCompactor();

        // NOT 6717096

        assertEquals(9_640_641_878_593L, solution.part2(lines));
    }
}