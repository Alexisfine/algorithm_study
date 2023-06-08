package leetcode_questions.graph.topological_sort;

import java.util.*;

public class _1857_Largest_Color_Value_In_A_Directed_Graph {

    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inMap = new int[N];
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            inMap[edges[i][1]]++;
        }
        int[][] nodeColorMap = new int[N][26];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inMap[i] == 0) {
                queue.offer(i);
            }
        }
        int visitedNodes = 0;
        int maxColor = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            visitedNodes++;
            nodeColorMap[curNode][colors.charAt(curNode) - 'a']++;
            maxColor = Math.max(maxColor, nodeColorMap[curNode][colors.charAt(curNode) - 'a']);
            if (graph.containsKey(curNode)) {
                for (int nextNode : graph.get(curNode)) {
                    for (int i = 0; i < 26; i++) {
                        nodeColorMap[nextNode][i] = Math.max(nodeColorMap[nextNode][i], nodeColorMap[curNode][i]);
                        maxColor = Math.max(maxColor, nodeColorMap[nextNode][i]);
                    }
                    inMap[nextNode]--;
                    if (inMap[nextNode] == 0) {
                        queue.offer(nextNode);
                    }
                }
            }
        }
        return visitedNodes == N ? maxColor : -1;
    }
}
