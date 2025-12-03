package day03;

import java.util.List;

public class Lobby {
    public long part1(List<String> lines) throws NumberFormatException {
        var result = 0L;

        for (String line : lines) {
            long[] batteries = new long[line.length()];

            for (int i=0; i < line.length(); i++) {
                batteries[i] = Long.parseLong(String.valueOf(line.charAt(i)));
            }

            result += getMaxJoltage(batteries);
        }

        return result;
    }

    public long part2(List<String> lines) {
        var result = 0L;

        for (String line : lines) {
            long[] batteries = new long[line.length()];

            for (int i=0; i < line.length(); i++) {
                batteries[i] = Long.parseLong(String.valueOf(line.charAt(i)));
            }

            result += getMaxJoltage(batteries, 12);
        }

        return result;
    }

    public long getMaxJoltage(long[] batteries) {
        // First, find the largest number, excluding the very last one
        // Then, find the next largest number after the first largest number

        int largestIndex = -1;
        long largestValue = -1;

        for (int i=0; i < batteries.length - 1; i++) {
            if (batteries[i] > largestValue) {
                largestValue = batteries[i];
                largestIndex = i;
            }
        }

        long nextLargestValue = -1;

        for (int i=largestIndex + 1; i < batteries.length; i++) {
            if (batteries[i] > nextLargestValue) nextLargestValue = batteries[i];
        }

        return largestValue * 10 + nextLargestValue;
    }

    public long getMaxJoltage(long[] batteries, int digits) {
        // First, find the largest number, excluding the very last one
        // Then, find the next largest number after the first largest number

        int largestIndex = -1;
        long largestValue = -1;

        for (int i=0; i < batteries.length - 1; i++) {
            if (batteries[i] > largestValue) {
                largestValue = batteries[i];
                largestIndex = i;
            }
        }

        long nextLargestValue = -1;

        for (int i=largestIndex + 1; i < batteries.length; i++) {
            if (batteries[i] > nextLargestValue) nextLargestValue = batteries[i];
        }

        return largestValue * 10 + nextLargestValue;
    }

    public long getMaxJoltage(long[] batteries, int startIndex, int digits) {
        
    }

}