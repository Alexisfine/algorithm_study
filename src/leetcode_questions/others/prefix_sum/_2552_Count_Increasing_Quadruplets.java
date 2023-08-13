package leetcode_questions.others.prefix_sum;

public class _2552_Count_Increasing_Quadruplets {
    public long countQuadruplets(int[] nums) {
        int N = nums.length;
        int[][] pre = new int[N][N + 1];
        int[][] post = new int[N][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N; j++) {
                pre[i][j] = i > 0 ? pre[i - 1][j] : 0;
                if (nums[i] < j) pre[i][j]++;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= N; j++) {
                post[i][j] = i < N - 1 ? post[i + 1][j] : 0;
                if (nums[i] > j) post[i][j]++;
            }
        }

        long res = 0;
        for (int j = 1; j < N; j++) {
            for (int k = j + 1; k < N - 1; k++) {
               if (nums[j] > nums[k]) {
                   res += (long) pre[j - 1][nums[k]] * post[k + 1][nums[j]];
               }
            }
        }
        return res;
    }
}
