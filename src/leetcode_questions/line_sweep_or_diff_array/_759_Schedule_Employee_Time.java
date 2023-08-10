package leetcode_questions.line_sweep_or_diff_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _759_Schedule_Employee_Time {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    class Solution {
        private record Pair(int time, int value) {}
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<Pair> list = new ArrayList<>();
            for (List<Interval> employee : schedule) {
                for (Interval interval : employee) {
                    list.add(new Pair(interval.start, 1));
                    list.add(new Pair(interval.end, -1));
                }
            }
            Collections.sort(list, (a, b) -> {
                if (a.time != b.time) return a.time - b.time;
                return b.value - a.value;
            });

            List<Interval> res = new ArrayList<>();
            int cur = 0;
            int start = 0;
            int end = 0;
            cur += list.get(0).value;
            for (int i = 1; i < list.size(); i++) {
                Pair pair = list.get(i);
                if (cur > 0 && cur + pair.value == 0) {
                    start = pair.time;
                } else if (cur == 0 && cur + pair.value > 0) {
                    end = pair.time;
                    res.add(new Interval(start, end));
                }
                cur += pair.value;
            }
            return res;
        }


    }
}
