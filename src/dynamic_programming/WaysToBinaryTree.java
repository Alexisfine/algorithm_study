package dynamic_programming;

public class WaysToBinaryTree {
    private static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static int process(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int leftWays = process(i);
            int rightWays = process(n - i - 1);
            res += leftWays * rightWays;
        }
        return res;
    }

    public static int numTrees(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i - 1; j++) dp[i] += dp[j] * dp[i- j - 1];
        }
        return dp[n];
    }
}
