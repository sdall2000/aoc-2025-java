package yr2024.day04;

import common.Utilities;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CeresSearchTest {
    @Test
    void part1() throws IOException {
        var lines = Utilities.readResourceLines("/yr2024/day04/input.txt");
        var solution = new CeresSearch();

        assertEquals(2_344, solution.part1(lines));
    }

    @Test
    void part2() throws IOException {
        var lines = Utilities.readResourceLines("/yr2024/day04/input.txt");
        var solution = new CeresSearch();

        assertEquals(1_815, solution.part2(lines));
    }
}