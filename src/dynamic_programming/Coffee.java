package dynamic_programming;

import java.util.Comparator;
import java.util.PriorityQueue;


// VERY HARD
// Greedy + DP
public class Coffee {
    private static class CoffeeMachine {
        int availableTime;
        int duration;
        public CoffeeMachine(int a, int d) {
            availableTime = a;
            duration = d;
        }
    }

    private static class CoffeeMachineComparator implements Comparator<CoffeeMachine> {
        @Override
        public int compare(CoffeeMachine o1, CoffeeMachine o2) {
            return (o1.availableTime + o1.duration) - (o2.availableTime + o2.duration);
        }
    }

    public static int minTimeBruteForce(int[] arr, int people, int washingTime, int noWashingTime) {
        PriorityQueue<CoffeeMachine> pq = new PriorityQueue<>(new CoffeeMachineComparator());
        // add coffee machine instance into the min heap
        for (int i = 0; i < arr.length; i++) pq.add(new CoffeeMachine(0, arr[i]));
        // create an array to record drank time for every one
        int[] drankTime = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            CoffeeMachine fastest = pq.poll();
            fastest.availableTime += fastest.duration;
            drankTime[i] = fastest.availableTime;
            pq.add(fastest);
        }
        return process(drankTime, washingTime, noWashingTime, 0, 0);
    }

    // index: who is currently washing
    // washLine: when coffee washing machine is available
    private static int process(int[] drinks, int washingTime, int noWashingTime, int index, int washLine) {
        // base case
        if (index == drinks.length - 1) {
            return Math.min(Math.max(washLine, drinks[index]) + washingTime, drinks[index] + noWashingTime);
        }

        int washCoffee = Math.max(washLine, drinks[index]) + washingTime;
        int option1 = process(drinks, washingTime, noWashingTime, index + 1, washCoffee);
        int p1 = Math.max(washCoffee, option1);

        int dryCoffee = drinks[index] + noWashingTime;
        int option2 = process(drinks, washingTime, noWashingTime, index + 1, washLine);
        int p2 = Math.max(dryCoffee, option2);

        return Math.min(p1, p2);
    }


    // 2 mutable variables, so create a 2D array for index and washLine for DP
    public static int minTimeDP(int[] arr, int people, int washingTime, int noWashingTime) {
        PriorityQueue<CoffeeMachine> pq = new PriorityQueue<>(new CoffeeMachineComparator());
        // add coffee machine instance into the min heap
        for (int i = 0; i < arr.length; i++) pq.add(new CoffeeMachine(0, arr[i]));
        // create an array to record drank time for every one
        int[] drankTime = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            CoffeeMachine fastest = pq.poll();
            fastest.availableTime += fastest.duration;
            drankTime[i] = fastest.availableTime;
            pq.add(fastest);
        }

        // max washLine value
        int[][] dp = new int[people][drankTime[people - 1] + people * washingTime];
        for (int i = 0; i < dp[0].length; i++) {
            dp[people - 1][i] = Math.min(Math.max(i, drankTime[people-1]) + washingTime, drankTime[people-1]+noWashingTime);
        }
        for (int row = people - 2; row >= 0; row--) {
            // max washLine value
            int washLine = drankTime[row] + (row + 1) * washingTime;
            for (int col = 0; col < washLine; col++) {
                int wash = Math.max(col, drankTime[row]) + washingTime;
                dp[row][col] = Math.min(Math.max(wash, dp[row+1][wash]), Math.max(drankTime[row] + noWashingTime, dp[row+1][washLine]));
            }
        }
        return dp[0][0];
    }
}
