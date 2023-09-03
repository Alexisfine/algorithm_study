package leetcode_questions.dynamic_programming.basic_ii;

import java.util.ArrayList;
import java.util.List;

public class _1964_Find_The_Longest_Valid_Obstacle_Course_At_Each_Position {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int N = obstacles.length;
        List<Integer> arr = new ArrayList<>();
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            if (arr.isEmpty() || arr.get(arr.size() - 1) <= obstacles[i]) {
                arr.add(obstacles[i]);
                res[i] = arr.size();
            } else {
                int index = binarySearch(arr, obstacles[i]);
                arr.set(index, Math.min(arr.get(index), obstacles[i]));
                res[i] = index + 1;
            }
        }
        return res;
    }

    private int binarySearch(List<Integer> arr, int k) {
        int lo = 0;
        int hi = arr.size() - 1;
        if (arr.get(0) > k) return 0;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) <= k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /*
    1 1 3 3 5
    4 4 5 5
    1 2 4 4 4
     */
}
