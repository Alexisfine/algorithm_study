package leetcode_questions.monotonic_stack.next_greater_or_smaller;

import java.util.Stack;

public class _85_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] hist = new int[N];
        int res = 0;

        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                if (matrix[i][j] == '1') {
                    hist[j]++;
                } else {
                    hist[j] = 0;
                }
                res = Math.max(res, largestRectangleArea(hist));
            }
        }
        return res;
    }

    private int largestRectangleArea(int[] hist) {
        int N = hist.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <N; i++) {
            while (!stack.isEmpty() && hist[stack.peek()] > hist[i]) {
                int index = stack.pop();
                max = Math.max(max, (i - index) * hist[index]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            max = Math.max(max, (hist.length - 1 - index) * hist[index]);
        }
        return max;
    }

    /*
    area[x][y][i][j] = preSum[i][j] - preSum[i-1][y] - preSum[x][j-1] + preSum[x-1][y-1]
    still need to iterate x,y,i,j O(n^4)
    用两层循环决定上下边界，压缩成1D
     */
}
