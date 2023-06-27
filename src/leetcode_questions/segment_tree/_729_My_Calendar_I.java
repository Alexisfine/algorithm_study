package leetcode_questions.segment_tree;

import java.util.Map;
import java.util.TreeMap;

public class _729_My_Calendar_I {
    public class MyCalendar {
        TreeMap<Integer, Integer> calendar;
        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> event = calendar.lowerEntry(end);
            if (event != null && event.getValue() > start) return false;
            calendar.put(start, end);
            return true;
        }
    }
}
