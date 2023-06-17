package leetcode_questions.greedy;

import java.util.Arrays;

public class _1833_Maximum_Ice_Cream_Bars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int iceCream = 0;
        for (int i = 0; i < costs.length && coins >= costs[i]; i++) {
            coins -= costs[i];
            iceCream++;
        }
        return iceCream;
    }
}
