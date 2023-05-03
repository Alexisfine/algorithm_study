package recursion;

public class Knapsack {
    public static int process1(int[] weights, int[] values, int i, int alreadyDoneWeight, int bag) {
        if (alreadyDoneWeight > bag) return 0;
        if (i == weights.length) return 0;
        return Math.max(
                process1(weights, values, i + 1, alreadyDoneWeight, bag),
                values[i] + process1(weights, values, i + 1, alreadyDoneWeight + values[i], bag)
        );
    }
}
