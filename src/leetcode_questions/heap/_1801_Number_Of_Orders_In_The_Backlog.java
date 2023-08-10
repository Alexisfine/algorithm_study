package leetcode_questions.heap;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class _1801_Number_Of_Orders_In_The_Backlog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int modulo = (int) Math.pow(10, 9) + 7;
        TreeMap<Integer, Integer> buyOrder = new TreeMap<>();
        TreeMap<Integer, Integer> sellOrder = new TreeMap<>();

        long size = 0;
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            if (order[2] == 0) {
                buyOrder.put(price, buyOrder.getOrDefault(price, 0) + amount);

            } else {
                sellOrder.put(price, sellOrder.getOrDefault(price, 0) + amount);
            }
            size += amount;
        }

        while (!buyOrder.isEmpty() && !sellOrder.isEmpty()) {
            // check exec of buy orders
            Map.Entry<Integer, Integer> buy = buyOrder.firstEntry();
            Map.Entry<Integer, Integer> sell = sellOrder.lastEntry();
            int minBuyPrice = buy.getKey();
            int maxSellPrice = sell.getKey();
            int minBuyOrders = buy.getValue();
            int maxSellOrders = sell.getValue();
            if (minBuyOrders >= maxSellPrice) {
                minBuyOrders--;
                maxSellOrders--;
                size -= 2;
            } else break;


            if (minBuyOrders > 0) {
                buyOrder.put(minBuyPrice, minBuyOrders);
            } else {
                buyOrder.remove(minBuyPrice);
            }

            if (maxSellOrders > 0) {
                sellOrder.put(maxSellPrice, maxSellOrders);
            } else {
                sellOrder.remove(maxSellOrders);
            }
        }

        while (!buyOrder.isEmpty() && !sellOrder.isEmpty()) {
            // check exec of buy orders
            Map.Entry<Integer, Integer> buy = buyOrder.lastEntry();
            Map.Entry<Integer, Integer> sell = sellOrder.firstEntry();
            int maxBuyPrice = buy.getKey();
            int minSellPrice = sell.getKey();
            int maxBuyOrders = buy.getValue();
            int minSellOrders = sell.getValue();
            if (maxBuyPrice >= minSellPrice) {
                maxBuyOrders--;
                minSellOrders--;
                size -= 2;
            } else break;

            if (maxBuyOrders > 0) {
                buyOrder.put(maxBuyPrice, maxBuyOrders);
            } else {
                buyOrder.remove(maxBuyPrice);
            }

            if (minSellOrders > 0) {
                sellOrder.put(minSellPrice, minSellOrders);
            } else {
                sellOrder.remove(minSellPrice);
            }
        }
        return (int) (size % modulo);
    }

}
