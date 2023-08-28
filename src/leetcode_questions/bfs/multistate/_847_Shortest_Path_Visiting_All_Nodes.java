package leetcode_questions.bfs.multistate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _847_Shortest_Path_Visiting_All_Nodes {
    private record Pair(int node, int state) {}
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int finalState = 0;
        for (int i = 0; i < N; i++) finalState |= (1 << i);

        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        for (int i = 0; i < N; i++) {
            Pair pair = new Pair(i, 1 << i);
            queue.offer(pair);
            visited.add(pair);
        }

        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair curNode = queue.poll();
                for (int nextNode : graph[curNode.node]) {
                    int nextState = curNode.state | (1 << nextNode);
                    if (nextState == finalState) return step + 1;
                    Pair nextPair = new Pair(nextNode, nextState);
                    if (!visited.contains(nextPair)) {
                        visited.add(nextPair);
                        queue.offer(nextPair);
                    }
                }
            }

        }
        return 0;
    }

    /*
    state compression 1010
     */
}
