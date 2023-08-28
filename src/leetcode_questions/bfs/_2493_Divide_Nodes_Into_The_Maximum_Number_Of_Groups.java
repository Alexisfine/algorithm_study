package leetcode_questions.bfs;


import java.util.*;

public class _2493_Divide_Nodes_Into_The_Maximum_Number_Of_Groups {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> next = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            next.putIfAbsent(edge[0], new ArrayList<>());
            next.putIfAbsent(edge[1], new ArrayList<>());
            next.get(edge[0]).add(edge[1]);
            next.get(edge[1]).add(edge[0]);
        }

        for (int start = 1; start <= n; start++) {
            Queue<Integer> queue = new LinkedList<>();
            int[] visited = new int[505];
            int curDepth = 0;
            int minNodeId = Integer.MAX_VALUE;

            queue.offer(start);
            visited[start] = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curNode = queue.poll();
                    minNodeId = Math.min(minNodeId, curNode);
                    if (next.containsKey(curNode)) {
                        for (int nextNode : next.get(curNode)) {
                            if (visited[nextNode] == 0) {
                                visited[nextNode] = curDepth + 2;
                                queue.offer(nextNode);
                            } else if (visited[nextNode] == visited[curNode]) {
                                return -1;
                            }
                        }
                    }
                }
                curDepth++;
            }
            if (!map.containsKey(minNodeId)) map.put(minNodeId, curDepth);
            else {
                int val = map.get(minNodeId);
                map.put(minNodeId, Math.max(val, curDepth));
            }
        }

        int res = 0;
        for (var entry : map.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }
}
