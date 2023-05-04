package dynamic_programming;

public class CoinWays {
    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int num = 0; num * arr[index] <= rest; num++) {
            ways += process(arr, index + 1, rest - num * arr[index]);
        }
        return ways;
    }

    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return 0;
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;

        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col < aim + 1; col++) {
                dp[row][col] = 0;
                int i = col;
                while (col - i >= 0) {
                    dp[row][col] += dp[row+1][col - i];
                    i += arr[row];
                }
            }
        }
        return dp[0][aim];
    }

    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return 0;
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;

        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col < aim + 1; col++) {
                dp[row][col] = dp[row+1][col];
                if (col - arr[row] > 0) dp[row][col] += dp[row][col - arr[row]];
            }
        }
        return dp[0][aim];
    }
}
