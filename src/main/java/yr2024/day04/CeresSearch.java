package yr2024.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import common.CharGrid;
import common.RowCol;

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
        if (charGrid.valueAt(row, col) != word.charAt(0)) return 0;

        int count = 0;

        // Loop through each direction and see if we can build the word
        for (RowCol rowCol : CharGrid.ALL_OFFSETS) {
            int newRow = row;
            int newCol = col;
            for (int i=1; i < word.length(); i++) {
                newRow += rowCol.row();
                newCol += rowCol.col();

                if (!charGrid.inBounds(newRow, newCol) || !(charGrid.valueAt(newRow, newCol) == word.charAt(i))) break;

                // We are still good. If this is the last letter, then we found a match
                if (i == word.length() - 1) count++;
            }
        }

        return count;
    }

    public long part2(List<String> lines) {
        var result = 0L;

        CharGrid charGrid = new CharGrid(lines);
        
        // Visit each row/column, and find how many instances of XMAS start at that position
        for (int row = 0; row < charGrid.getRowCount(); row++) {
            for (int col = 0; col < charGrid.getColCount(); col++) {
                if (isXmas(charGrid, row, col)) result++;
            }
        }

        return result;
    }

    private boolean isXmas(CharGrid charGrid, int row, int col) {
        if (charGrid.valueAt(row, col) != 'A') return false;

        List<Character> remaining = new ArrayList<>(List.of('M', 'S'));

        if (charGrid.valueEquals(row-1, col-1, 'M') || charGrid.valueEquals(row-1, col-1, 'S')) {
            remaining.remove((Character) charGrid.valueAt(row-1, col-1));

            if (charGrid.valueEquals(row+1, col+1, remaining.get(0))) {
                remaining = new ArrayList<>(List.of('M', 'S'));

                if (charGrid.valueEquals(row-1, col+1, 'M') || charGrid.valueEquals(row-1, col+1, 'S')) {
                    remaining.remove((Character) charGrid.valueAt(row-1, col+1));

                    if (charGrid.valueEquals(row+1, col-1, remaining.get(0))) return true;
                }
            }
        }

        return false;
    }
}