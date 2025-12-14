package yr2025.day10;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factory {
    public long part1(List<String> lines) {
        var result = 0L;

        // Sample: [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}

        Pattern pattern = Pattern.compile("\\[.*?\\]");
        Pattern digits = Pattern.compile("\\((\\d+(?:,\\d+)*)\\)");

        for (String machineLine : lines) {
            Matcher matcher = pattern.matcher(machineLine);
            Matcher digitsMatcher = digits.matcher(machineLine);

            if (!matcher.find()) return -1;

            String endStateString = matcher.group(0);

            if (!digitsMatcher.find()) return -1;

            for (int i=1; i <= digitsMatcher.groupCount(); i++) {
                System.out.println(digitsMatcher.group(0));
            }
        }

        return result;
    }

    public long part2(List<String> lines) {
        var result = 0L;

        return result;
    }

    private class Machine {
        private boolean[] currentState;
        private boolean[] goalState;
        private List<boolean[]> buttons;
        private int[] joltageRequirements;

        public Machine(
            boolean[] currentState,
            boolean[] goalState,
            List<boolean[]> buttons,
            int[] joltageRequirements) {
            this.currentState = currentState;
            this.goalState = goalState;
            this.buttons = buttons;
            this.joltageRequirements = joltageRequirements;
        }
    }
}