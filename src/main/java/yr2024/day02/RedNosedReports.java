package yr2024.day02;

import java.util.Collection;
import java.util.List;

public class RedNosedReports {
    public long part1(List<String> lines) {
        var result = 0L;

        return result;
    }

    public long part2(List<String> lines) {
        var result = 0L;

        return result;
    }

    private boolean validateReport(Collection<Long> report) {
        Long lastLevel = null;
        Boolean increasing = null;

        for(Long level : report) {
            if (lastLevel == null) {
                lastLevel = level;
            } else {
                if (lastLevel.equals(level)) return false;

                if (increasing == null) {
                    increasing = level > lastLevel;
                }


            }
        }

        return true;
    }
}