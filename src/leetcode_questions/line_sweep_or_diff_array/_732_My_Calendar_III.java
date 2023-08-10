package leetcode_questions.line_sweep_or_diff_array;

import java.util.Map;
import java.util.TreeMap;

public class _732_My_Calendar_III {
    class MyCalendarThree {
        TreeMap<Integer, Integer> map;

        public MyCalendarThree() {
            this.map = new TreeMap<>();
        }

        public int book(int startTime, int endTime) {
            if (!map.containsKey(startTime)) {
                map.put(startTime, 1);
            } else {
                map.put(startTime, map.get(startTime) + 1);
            }

            if (!map.containsKey(endTime)) {
                map.put(endTime, -1);
            } else {
                map.put(endTime, map.get(endTime) - 1);
            }

            int max = 0;
            int cur = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cur += entry.getValue();
                max = Math.max(max, cur);
            }
            return max;
        }
    }
}
