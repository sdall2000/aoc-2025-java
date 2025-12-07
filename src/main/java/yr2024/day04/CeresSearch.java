package yr2024.day04;

import java.util.List;

import common.CharGrid;

public class CeresSearch {
    private static final String WORD = "XMAS";

    public long part1(List<String> lines) {
        var result = 0L;

        CharGrid charGrid = new CharGrid(lines);
        
        // Visit each row/column, and find how many instances of XMAS start at that position
        for (int row = 0; row < charGrid.getRowCount(); row++) {
            for (int col = 0; col < charGrid.getColCount(); col++) {
                result += getMatches(charGrid, row, col, WORD);
            }
        }

        return result;
    }

    private int getMatches(CharGrid charGrid, int row, int col, String word) {
        
    }

    public long part2(List<String> lines) {
        var result = 0L;

        return result;
    }
}