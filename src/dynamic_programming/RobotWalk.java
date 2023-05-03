package dynamic_programming;

public class RobotWalk {
    public static int walkWays1(int N, int E, int S, int K) {
        return f1(N, E, S, K);
    }

    private static int f1(int N, int E, int rest, int cur) {
        if (rest == 0) return cur == E ? 1 : 0;
        if (cur == 1) {
            return f1(N, E, rest - 1, cur + 1);
        }
        if (cur == N) {
            return f1(N, E, rest - 1, cur - 1);
        }
        return f1(N, E, rest - 1, cur + 1) + f1(N, E, rest - 1, cur - 1);
    }

    public static int walkWays2(int N, int E, int S, int K) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -1;
        }
        return f2(N, E, S, K, dp);
    }

    private static int f2(int N, int E, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) return dp[rest][cur];
        if (rest == 0) {
            dp[rest][cur] = E == cur ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1) {
            dp[rest][cur] = f2(N, E, rest - 1, cur + 1, dp);
            return dp[rest][cur];
        }
        if (cur == N) {
            dp[rest][cur] =  f2(N, E, rest - 1, cur - 1, dp);
            return dp[rest][cur];
        }
        dp[rest][cur] = f2(N, E, rest - 1, cur + 1, dp) + f2(N, E, rest - 1, cur - 1, dp);
        return dp[rest][cur];
    }



    public static void main(String[] args) {
        System.out.println(walkWays2(5, 2, 4, 4));
    }
}
