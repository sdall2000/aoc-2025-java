package yr2025.day11;

import common.Utilities;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReactorTest {
    @Test
    void part1() throws IOException {
        var lines = Utilities.readResourceLines("/yr2025/day11/input.txt");
        var solution = new Reactor();

        assertEquals(662, solution.part1(lines));
    }

    @Test
    void part2() throws IOException {
        var lines = Utilities.readResourceLines("/yr2025/day11/input.txt");
        var solution = new Reactor();

        assertEquals(429_399_933_071_120L, solution.part2(lines));
    }
}