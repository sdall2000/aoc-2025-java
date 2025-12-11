package yr2025.day11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reactor {
    public long part1(List<String> lines) {
        Map<String, Set<String>> paths = new HashMap<>();

        for (String line : lines) {
            String split[] = line.split(":\\s+|\\s+");

            Set<String> outputs = new HashSet<>();

            for (int i=1; i < split.length; i++) {
                outputs.add(split[i]);
            }

            paths.put(split[0], outputs);
        }

        return countPaths(paths, "you", "out", new HashSet<>());
    }

    private long countPaths(Map<String, Set<String>> map, String current, String end, Set<String> pathsSoFar) {
        if (current.equals(end)) return 1;

        long localCount = 0;

        // Try each output
        for (String next : map.get(current)) {
            // Check for infinite loops
            if (pathsSoFar.contains(next)) break;

            pathsSoFar.add(next);

            localCount += countPaths(map, next, end, pathsSoFar);

            pathsSoFar.remove(next);
        }

        return localCount;
    }

    public long part2(List<String> lines) {
        Map<String, Set<String>> paths = new HashMap<>();

        for (String line : lines) {
            String split[] = line.split(":\\s+|\\s+");

            Set<String> outputs = new HashSet<>();

            for (int i=1; i < split.length; i++) {
                outputs.add(split[i]);
            }

            paths.put(split[0], outputs);
        }

        return countPathsFftDac(paths, "svr", "out", new HashSet<>(), new HashMap<>());
    }

    private long countPathsFftDac(Map<String, Set<String>> map, String current, String end, Set<String> pathsSoFar, Map<State, Long> memo) {
        if (current.equals(end)) {
            if (pathsSoFar.contains("fft") && pathsSoFar.contains("dac")) return 1;
            else return 0;
        }

        long localCount = 0;

        State currentState = new State(current, pathsSoFar.contains("dac"), pathsSoFar.contains("fft"));

        if (memo.containsKey(currentState)) return memo.get(currentState);

        // Try each output
        for (String next : map.get(current)) {
            // Check for infinite loops
            if (pathsSoFar.contains(next)) break;

            pathsSoFar.add(next);

            long pathCount = countPathsFftDac(map, next, end, pathsSoFar, memo);
            
            localCount += pathCount;

            pathsSoFar.remove(next);
        }

        memo.put(currentState, localCount);

        return localCount;
    }

    private record State(String name, boolean dacVisited, boolean fftVisited) {

    }
}