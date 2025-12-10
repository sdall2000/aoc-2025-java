package yr2025.day10;

import common.Utilities;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    void part1() throws IOException {
        var lines = Utilities.readResourceLines("/yr2025/day10/input.txt");
        var solution = new Factory();

        assertEquals(-1, solution.part1(lines));
    }

    @Test
    void part2() throws IOException {
        var lines = Utilities.readResourceLines("/yr2025/day10/input.txt");
        var solution = new Factory();

        assertEquals(-1, solution.part2(lines));
    }
}