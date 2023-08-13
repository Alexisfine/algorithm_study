package leetcode_questions.others.line_sweep_or_diff_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1094_Car_Pooling {
    private record Pair(int time, int value) {}
    public boolean carPooling(int[][] trips, int capacity) {
        List<Pair> list = new ArrayList<>();
        for (int[] trip : trips) {
            int people = trip[0];
            list.add(new Pair(trip[1], people));
            list.add(new Pair(trip[2], -people));
        }

        Collections.sort(list, (a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;
            }
            return a.value - b.value;
        });

        int people = 0;
        for (Pair pair : list) {
            people += pair.value;
            if (people > capacity) return false;
        }
        return true;
    }
}
