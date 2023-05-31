package leetcode_questions.dynamic_programming.subarray_sequence_string;

import java.util.HashMap;

public class _1218_Longest_Arithmetic_Subsequence_With_Given_Difference {
    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = arr.length;
        int max = 1;
        for (int i = 0; i < N; i++) {
            int value = 1;
            if (map.containsKey(arr[i] - difference)) {
                value += map.get(arr[i] - difference);
            }
            map.put(arr[i], value);
            max = Math.max(max, value);
        }
        return max;
    }
}
