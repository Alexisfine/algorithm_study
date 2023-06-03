package leetcode_questions.graph.dfs;

import java.util.*;

public class _332_Reconstruct_Itinerary {
    private List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> graph = new HashMap<>(tickets.size());
        HashMap<List<String>, Integer> visited = new HashMap<>(tickets.size());

        int size = tickets.size();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);

            List<String> list = List.of(from, to);
            visited.putIfAbsent(list, 0);
            visited.put(list, visited.get(list) + 1);
        }

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
        }

        process(graph, visited, "JFK", 0, size);
        return path;

    }

    private boolean process(Map<String, List<String>> graph, HashMap<List<String>, Integer> visited,
                                 String current, int currentNum, int total) {
        // base case
        if (currentNum == total) {
            path.add(current);
            return true;
        }

        path.add(current);
        currentNum++;

        if (graph.containsKey(current)) {
            for (String next : graph.get(current)) {
                List<String> ticket = List.of(current, next);
                if (!visited.containsKey(ticket) || visited.get(ticket) == 0) continue;
                visited.put(ticket, visited.get(ticket) - 1);
                boolean success = process(graph, visited, next, currentNum, total);
                if (success) return true;
                visited.put(ticket, visited.get(ticket) + 1);
            }
        }

        path.remove(path.size() - 1);
        currentNum--;

        return false;
    }


}
