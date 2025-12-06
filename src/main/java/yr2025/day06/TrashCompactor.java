package yr2025.day06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrashCompactor {
    public long part1(List<String> lines) {
        var result = 0L;

        List<List<Long>> numbers = new ArrayList<>();

        for (String line : lines) {
            line = line.trim();

            String[] split = line.split("\\s+");

            try {
                Long.parseLong(split[0]);

                for (int i=0; i < split.length; i++) {
                    if (numbers.size() < split.length) {
                        numbers.add(new ArrayList<>());
                    }

                    numbers.get(i).add(Long.parseLong(split[i]));
                }
            } catch (Exception e) {
                for (int i=0; i < split.length; i++) {
                    String op = split[i];

                    result += calculate(numbers.get(i), op);
                }
            }
        }

        return result;
    }

    private long calculate(Collection<Long> numbers, String operator) {
        if (operator.equals("+")) {
            return numbers.stream().mapToLong(Long::longValue).sum();
        } else {
            return numbers.stream().reduce(1L, (a, b) -> a * b);
        }
    }

    public long part2(List<String> lines) {
        long result = 0;

        String[] operators = lines.removeLast().trim().split("\\s+");

        int lineLength = lines.stream().mapToInt(String::length).max().orElse(0);
        int lastLineIndex = lineLength - 1;

        int operatorIndex = operators.length - 1;
        List<Long> numbers = new ArrayList<>();

        // Loop through each character column of the rows, going backwards
        for (int c=lastLineIndex; c >= 0; c--) {

            if (isGap(c, lines)) {
                result += calculate(numbers, operators[operatorIndex--]);
                numbers.clear();
            } else {
                StringBuilder sb = new StringBuilder();

                // Go through each row
                for (int i=0; i < lines.size(); i++) {
                    String line = lines.get(i);

                    if ((c > line.length() - 1) || (line.charAt(c) == ' ')) {
                        // sb.append("0");
                    } else {
                        sb.append(line.charAt(c));
                    }
                }

                // We have a number now
                numbers.add(Long.parseLong(sb.toString()));
            }
        }

        // process the last set of numbers
        result += calculate(numbers, operators[operatorIndex]);

        return result;
    }

    private boolean isGap(int columnIndex, List<String> lines) {
        for (String line : lines) {
            if (columnIndex < line.length() && line.charAt(columnIndex) != ' ') return false;
        }
        return true;
    }

    public long part2x(List<String> lines) {
        var result = 0L;

        List<ArrayList<String>> numbers = new ArrayList<>();

        for (String line : lines) {
            line = line.trim();

            String[] split = line.split("\\s+");

            try {
                Long.parseLong(split[0]);

                for (int i=0; i < split.length; i++) {
                    if (numbers.size() < split.length) {
                        numbers.add(new ArrayList<>());
                    }

                    numbers.get(i).add(split[i]);
                }
            } catch (Exception e) {
                // Process each column with the given operator

                // Now go through each operator
                for (int i=0; i < split.length; i++) {
                    String op = split[i];

                    boolean done = false;
                    long localResult = 0;

                    ArrayList<String> nums = numbers.get(i);

                    while (!done) {
                        StringBuilder sb = new StringBuilder();

                        done = true;

                        for (int j = 0; j < nums.size(); j++) {
                            String numStr = nums.get(j);

                            if (numStr.isBlank()) {
                                sb.append("0");
                            } else {
                                done = false;
                                sb.append(numStr.substring(numStr.length() - 1));

                                if (numStr.length() == 1) {
                                    nums.set(j, "");
                                } else {
                                    nums.set(j, numStr.substring(0, numStr.length() - 1));
                                }
                            }
                        }

                        Long longNum = Long.parseLong(sb.toString());

                        if (op.equals("+")) {
                            localResult += longNum;
                        } else {
                            if (localResult == 0) localResult = 1;
                            localResult *= longNum;
                        }

                    }

                    result += localResult;

                }
            }
        }

        return result;
    }
}