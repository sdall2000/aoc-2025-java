package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RowColShape {
    private final List<RowCol> points = new ArrayList<>();

    private final Map<Integer, Set<Pair<Integer, Integer>>> horizontalLines = new TreeMap<>();
    private final Map<Integer, Set<Pair<Integer, Integer>>> verticalLines = new TreeMap<>();

    private int minCol = Integer.MAX_VALUE;
    private int maxCol = Integer.MIN_VALUE;
    private int minRow = Integer.MAX_VALUE;
    private int maxRow = Integer.MIN_VALUE;

    private Map<RowCol, Boolean> memo = new HashMap<>();

    public RowColShape(List<RowCol> points) {
        this.points.addAll(points);

        for (int i=0; i < this.points.size(); i++) {
            RowCol current = this.points.get(i);
            RowCol next = null;

            minCol = Math.min(minCol, current.col());
            maxCol = Math.max(maxCol, current.col());
            minRow = Math.min(minRow, current.row());
            maxRow = Math.max(maxRow, current.row());

            if (i != this.points.size()-1) {
                next = this.points.get(i+1);
            } else {
                next = this.points.get(0);
            }

            // The current and next RowCol will have either a row or a column in common
            if (current.row() == next.row()) {
                // This is a horizontal line
                int startCol = Math.min(current.col(), next.col());
                int endCol = Math.max(current.col(), next.col());

                var hlines = horizontalLines.get(current.row());

                if (hlines == null) {
                    horizontalLines.put(current.row(), new HashSet<>());
                    hlines = horizontalLines.get(current.row());
                }

                hlines.add(new Pair<>(startCol, endCol));
            } else {
                // This is a vertical line
                int startRow = Math.min(current.row(), next.row());
                int endRow = Math.max(current.row(), next.row());

                var vlines = verticalLines.get(current.col());

                if (vlines == null) {
                    verticalLines.put(current.col(), new HashSet<>());
                    vlines = verticalLines.get(current.col());
                }

                vlines.add(new Pair<>(startRow, endRow));
            }
        }
    }

    public boolean isPointInShape(RowCol rowCol) {
        if (memo.containsKey(rowCol)) return memo.get(rowCol);

        if (!inRange(rowCol.col(), minCol, maxCol) || !inRange(rowCol.row(), minRow, maxRow)) return false;

        long verticalCount = 0;
        long horizontalCount = 0;
        boolean onHline = false;
        boolean onVline = false;

        // Go through each row
        for (int row : horizontalLines.keySet()) {
            // Don't need to continue calculating if the row is greater than the current row
            if (row > rowCol.row()) break;

            // Get the horizontal lines that are on this row
            var hlines = horizontalLines.get(row);

            // Iterate through each horizontal line in row
            for (var hline : hlines) {

                if (inRange(rowCol.col(), hline.value0(), hline.value1())) {
                    horizontalCount++;
                    onHline = row == rowCol.row();
                    break;
                }
            }
        }

        for (int col : verticalLines.keySet()) {
            if (col > rowCol.col()) break;

            var vlines = verticalLines.get(col);

            for (var vline : vlines) {
                if (inRange(rowCol.row(), vline.value0(), vline.value1())) {
                    verticalCount++;
                    onVline = col == rowCol.col();
                    break;
                }
            }
        }

        boolean inShape = onHline || onVline || (horizontalCount % 2 == 1 && verticalCount % 2 == 1);

        memo.put(rowCol, inShape);

        return inShape;
    }

    public boolean inRange(int value, int min, int max) {
        int actualMin = Math.min(min, max);
        int actualMax = Math.max(min, max);

        return value >= actualMin && value <= actualMax;
    }
}