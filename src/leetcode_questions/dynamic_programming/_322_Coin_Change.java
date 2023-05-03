package leetcode_questions.dynamic_programming;

public class _322_Coin_Change {
    public int coinChange1(int[] coins, int amount) {
        return process1(coins, 0, amount);
    }

    private int process1(int[] coins, int index, int rest) {
        if (rest < 0) return -1;
        if (rest == 0) return 0;
        if (index == coins.length) return -1;

        int p1 = process1(coins, index + 1, rest);
        int p2Next = process1(coins, index + 1, rest - coins[index]);
        if (p1 == -1 && p2Next == -1) {
            return -1;
        } else if (p1 == -1) {
            return 1 + p2Next;
        } else if (p2Next == -1) {
            return p1;
        } else {
            return Math.min(p1, p2Next + 1);
        }
    }
}
