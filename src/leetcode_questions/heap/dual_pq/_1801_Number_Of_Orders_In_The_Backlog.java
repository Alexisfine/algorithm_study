package leetcode_questions.heap.dual_pq;

import java.util.PriorityQueue;

public class _1801_Number_Of_Orders_In_The_Backlog {
    public class Pair {
        long price;
        long amount;
        public Pair(long price, long amount) {
            this.price = price;
            this.amount = amount;
        }
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Pair> buyOrder = new PriorityQueue<>((a, b) ->  Math.toIntExact(b.price - a.price));
        PriorityQueue<Pair> sellOrder = new PriorityQueue<>((a, b) -> Math.toIntExact(a.price - b.price));

        long res = 0;
        long mod = (long) 1e9 + 7;

        for (var order : orders) {
            res = (res + order[1]) % mod;

            if (order[2] == 0) { // buy
                while (order[1] > 0 && !sellOrder.isEmpty() && sellOrder.peek().price <= order[0]) {
                    var sell = sellOrder.poll();
                    long num = Math.min(order[1], sell.amount);
                    sell.amount -= num;
                    order[1] -= num;
                    res = (res - num * 2 + mod) % mod;
                    if (sell.amount > 0) {
                        sellOrder.offer(sell);
                    }
                }
                if (order[1] > 0) {
                    buyOrder.offer(new Pair(order[0], order[1]));
                }
            } else {
                while (order[1] > 0 && !buyOrder.isEmpty() && buyOrder.peek().price >= order[0]) {
                    var buy = buyOrder.poll();
                    long num = Math.min(order[1], buy.amount);
                    buy.amount -= num;
                    order[1] -= num;
                    res = (res - num * 2 + mod) % mod;
                    if (buy.amount > 0) {
                        buyOrder.offer(buy);
                    }
                }
                if (order[1] > 0) {
                    sellOrder.offer(new Pair(order[0], order[1]));
                }
            }
        }
        return (int) res;
    }
}
