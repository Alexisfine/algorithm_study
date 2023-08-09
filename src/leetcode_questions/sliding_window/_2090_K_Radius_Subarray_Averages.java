package leetcode_questions.sliding_window;

import java.util.Arrays;

public class _2090_K_Radius_Subarray_Averages {
    public int[] getAverages(int[] nums, int k) {
        int size = 2 * k + 1;
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        if (size > N) return res;
        long cumSum = 0;
        for (int i = 0; i < size; i++) {
            cumSum += nums[i];
        }
        res[size - 1 - k] = (int) (cumSum / size);
        for (int i = size; i < N; i++) {
            cumSum -= nums[i - size];
            cumSum += nums[i];
            res[i - k] = (int) (cumSum / size);
        }
        return res;
    }
}
