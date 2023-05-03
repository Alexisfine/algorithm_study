package dynamic_programming;

public class CoinsMin {
    public static int minCoins1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) return -1;
        if (rest == 0) return 0;
        // rest > 0
        if (arr.length == index) return -1;

        // rest > 0 and arr.length > index
        int p1 = process(arr, index + 1, rest);
        int p2Next = process(arr, index + 1, rest - arr[index]);

        if (p1 == -1 && p2Next == -1) return -1;
        else if (p1 == -1) return 1 + p2Next;
        else if (p2Next == -1) return p1;
        else return Math.min(p1, 1 + p2Next);
    }

    public static int minCoins2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -2;
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (rest < 0) return -1;
        if (dp[index][rest] != -2) return dp[index][rest];
        if (rest == 0) {
            dp[index][rest] = 0;
            return 0;
        }
        if (arr.length == index) {
            dp[index][rest] = -1;
            return 0;
        }

        // rest > 0 and arr.length > index
        int p1 = process(arr, index + 1, rest);
        int p2Next = process(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2Next == -1) {
            dp[index][rest] = -1;
            return dp[index][rest];
        }
        else if (p1 == -1) {
            dp[index][rest] = 1 + p2Next;
            return dp[index][rest];
        }
        else if (p2Next == -1) {
            dp[index][rest] = p1;
            return dp[index][rest];
        }
        else {
            dp[index][rest] = Math.min(p1, 1 + p2Next);
            return dp[index][rest];
        }
    }


    public static int minCoins3(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[arr.length][j] = -1;
        }

        for (int index = dp.length - 2; index >= 0; index--) {
            for (int rest = 1; rest < dp[0].length; rest++) {
                int p1 = dp[index + 1][rest];
                int p2Next = -1;
                if (rest - arr[index] >= 0) p2Next = dp[index + 1][rest - arr[index]];
                if (p1 == -1 && p2Next == -1) {
                    dp[index][rest] = -1;
                }
                else if (p1 == -1) {
                    dp[index][rest] = 1 + p2Next;
                }
                else if (p2Next == -1) {
                    dp[index][rest] = p1;
                }
                else {
                    dp[index][rest] = Math.min(p1, 1 + p2Next);
                }

            }
        }
        return dp[0][aim];
    }
}
