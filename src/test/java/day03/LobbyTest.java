package day03;

import common.Utilities;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LobbyTest {
    @Test
    void part1() throws IOException {
        var lines = Utilities.readResourceLines("/day03/input.txt");
        var solution = new Lobby();

        assertEquals(17_031, solution.part1(lines));
    }

    @Test
    void part2() throws IOException {
        var lines = Utilities.readResourceLines("/day03/input.txt");
        var solution = new Lobby();

        assertEquals(-1, solution.part2(lines));
    }
}