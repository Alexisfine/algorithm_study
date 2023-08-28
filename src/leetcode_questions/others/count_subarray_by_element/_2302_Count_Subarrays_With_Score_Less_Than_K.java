package leetcode_questions.others.count_subarray_by_element;

public class _2302_Count_Subarrays_With_Score_Less_Than_K {
    public long countSubarrays(int[] nums, long k) {
        int N = nums.length;
        long[] preSum = new long[N];
        preSum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] >= k) continue;
            int lo = 0;
            int hi = i;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                long sum = 0;
                if (mid != 0) {
                    sum = preSum[i] - preSum[mid - 1];
                } else {
                    sum = preSum[i];
                }
                long product = sum * (i - mid + 1);
                if (product >= k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            res += (i - lo + 1);
        }
        return res;
    }

    /*
    X X X X X X X X X
            i
    以i为结尾的subarray，
     */
}
