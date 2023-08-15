package leetcode_questions.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _149_Max_Points_On_A_Line {
    public int maxPoints(int[][] points) {
        int N = points.length;
        int res = 1;
        for (int i = 0; i < N; i++) {
            int[] p1 = points[i];
            Map<Double, Integer> countMap = new HashMap<>();
            for (int j = i + 1; j < N; j++) {
                int[] p2 = points[j];
                double slope;
                if (p1[0] == p2[0]) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
                }
                if (slope == -0.0) slope = 0.0;
                countMap.putIfAbsent(slope, 0);
                countMap.put(slope, countMap.get(slope) + 1);
                res = Math.max(res, countMap.get(slope) + 1);
            }
        }
        return res;
    }
}
