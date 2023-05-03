package leetcode_questions.graph;

import java.util.*;

public class _787_Cheapest_Flights_Within_K_Stops {
    private class Edge {
        int from;
        int to;
        int weight;
        public Edge() {}
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) return 0;
        HashMap<Integer, Integer> price = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Edge>> nextTo = new HashMap<>();
        findMap(flights, nextTo);
        price.put(src, 0);
        int minAirport = getMinDistanceAirportUnVisited(price, visited);
        while (minAirport != -1) {
            if (nextTo.get(minAirport) == null) break;
            for (Edge edge : nextTo.get(minAirport)) {
                if (!price.containsKey(edge.to)) price.put(edge.to, price.get(minAirport) + edge.weight);
                price.put(edge.to, Math.min(price.get(minAirport) + edge.weight, price.get(edge.to)));
            }
            visited.add(minAirport);
            minAirport = getMinDistanceAirportUnVisited(price, visited);
        }
        return price.containsKey(dst) ? price.get(dst) : -1;

    }

    public void findMap(int[][] flights, HashMap<Integer, List<Edge>> map) {
        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) map.put(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    public int getMinDistanceAirportUnVisited(HashMap<Integer, Integer> prices, HashSet<Integer> visited) {
        int minAirport = -1;
        int minPrice = Integer.MAX_VALUE;
        for (Map.Entry entry : prices.entrySet()) {
            int key = (int) entry.getKey();
            int price = (int) entry.getValue();
            if (!visited.contains(key) && price < minPrice) {
                minAirport = key;
                minPrice = price;
            }
        }
        return minAirport;
    }
}
