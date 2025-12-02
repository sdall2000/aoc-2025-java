package day02;

import common.Utilities;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GiftShopTest {
    @Test
    void part1() throws IOException {
        var lines = Utilities.readResourceLines("/day02/input.txt");
        var solution = new GiftShop();

        assertEquals(-1, solution.part1(lines));
    }

    @Test
    void part2() throws IOException {
        var lines = Utilities.readResourceLines("/day02/input.txt");
        var solution = new GiftShop();

        assertEquals(-1, solution.part2(lines));
    }
}