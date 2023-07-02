package leetcode_questions.hashtable;

import java.util.*;

public class _352_Data_Stream_As_Disjoint_Intervals {
    class SummaryRanges {
        TreeMap<Integer, Integer> map;

        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int value) {
            Map.Entry<Integer, Integer> smallEntry = map.floorEntry(value);
            int left = value;
            int right = value;
            if (smallEntry != null) {
                if (smallEntry.getValue() >= value) return;
                if (smallEntry.getValue() + 1 == value) left = smallEntry.getKey();
            }
            Map.Entry<Integer, Integer> largeEntry = map.higherEntry(value);
            if (largeEntry != null && largeEntry.getKey() == value + 1) {
                right = largeEntry.getValue();
                map.remove(value + 1);
            }
            map.put(left, right);
        }

        public int[][] getIntervals() {
            int[][] res = new int[map.size()][2];
            int index = 0;
            for (var entry : map.entrySet()) {
                res[index][0] = entry.getKey();
                res[index++][1] = entry.getValue();
            }
            return res;
        }
    }
}
