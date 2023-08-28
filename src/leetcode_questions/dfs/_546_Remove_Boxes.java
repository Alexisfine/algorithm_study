package leetcode_questions.dfs;

public class _546_Remove_Boxes {
    int[] boxes;
    int[][][] dp = new int[100][100][100];
    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        return dfs(0, boxes.length - 1, 0);
    }

    private int dfs(int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];

        int i = r;
        int count = k;
        while (i >= l && boxes[i] == boxes[r]) {
            i--;
            count++;
        }
        dp[l][r][k] = dfs(l, i, 0) + count * count;

        for (int j = i; j >= l; j--) {
            if (boxes[j] != boxes[r]) continue;
            if (boxes[j] == boxes[r] && boxes[j + 1] == boxes[r]) continue;
            dp[l][r][k] = Math.max(dp[l][r][k], dfs(l, j, count) + dfs(j + 1, i, 0));
        }
        return dp[l][r][k];
    }

    /*
    dp[l][r]


    OOO XXX OOO XXX OOO
      ^   ^   ^   ^   ^
      j1  i1  j0  i0  r

    dp[l][r] = max(
    dp[l][i0] + count * count,
    dp[l][i1] + (count_0 * count)^2

    dp[l][r][k] k:number of contiguous elements after r

     */


}
