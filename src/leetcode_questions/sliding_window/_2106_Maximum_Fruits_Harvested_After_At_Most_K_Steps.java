package leetcode_questions.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class _2106_Maximum_Fruits_Harvested_After_At_Most_K_Steps {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int N = fruits.length;
        int[] preSum = new int[N];
        preSum[0] = fruits[0][1];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + fruits[i][1];
        }

        int res = 0;
        int mid = 0;
        while (fruits[mid][0] <= startPos) mid++;
        int j = 0;
        for (int i = mid; i < N; i++) {
            while (fruits[j][0] <= startPos && fruits[i][0] - startPos + 2 * (startPos - fruits[j][0]) > k) {
                j++;
            }
            if (fruits[j][0] <= startPos) {
                res = Math.max(res, preSum[i] - (j == 0 ? 0 : preSum[j - 1]));
            } else if (fruits[i][0] - startPos <= k) {
                res = Math.max(res, preSum[i] - (j == 0 ? 0 : preSum[j - 1]));
            }
        }

        mid = N - 1;
        while (fruits[mid][0] > startPos) mid--;
        j = N - 1;
        for (int i = mid; i >= 0; i--) {
            while (fruits[j][0] <= startPos && fruits[i][0] - startPos + 2 * (startPos - fruits[j][0]) > k) {
                j++;
            }
        }
        return res;
    }
}
