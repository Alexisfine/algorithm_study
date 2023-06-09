package leetcode_questions.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2049_Count_Nodes_With_The_Highest_Score {
    private class Info {
        int members;
        long maxScore;
        int numberOfNodesHighest;
        public Info(int members, long maxScore, int numberOfNodesHighest) {
            this.members = members;
            this.maxScore = maxScore;
            this.numberOfNodesHighest = numberOfNodesHighest;
        }
    }
    int[] parents;
    // Time: O(N)
    // Space: O(N)
    public int countHighestScoreNodes(int[] parents) {
        if (parents == null || parents.length == 0) return 0;
        if (parents.length == 1) return 1;

        this.parents = parents;
        int N = parents.length;
        int root = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            graph.putIfAbsent(parents[i], new ArrayList<>());
            graph.get(parents[i]).add(i);
            if (parents[i] == -1) {
                root = i;
            }
        }
        Info info = dfs(root, graph);
        return info.numberOfNodesHighest;
    }

    private Info dfs(int index, Map<Integer, List<Integer>> graph) {
        if (!graph.containsKey(index)) {
            return new Info(1, parents.length - 1, 1);
        }

        if (graph.get(index).size() == 2) {
            Info left = dfs(graph.get(index).get(0), graph);
            Info right = dfs(graph.get(index).get(1), graph);

            long curScore = left.members * right.members;
            int res = parents.length - left.members - right.members - 1;
            if (res > 0) curScore *= res;

            int curMembers = left.members + right.members + 1;
            long highestScore = Math.max(curScore, Math.max(left.maxScore, right.maxScore));

            int numberOfHighest = 0;
            if (highestScore == left.maxScore) {
                numberOfHighest += left.numberOfNodesHighest;
            }
            if (highestScore == right.maxScore) {
                numberOfHighest += right.numberOfNodesHighest;
            }
            if (highestScore == curScore) numberOfHighest++;

            return new Info(curMembers, highestScore, numberOfHighest);
        } else if (graph.get(index).size() == 1) {
            Info child = dfs(graph.get(index).get(0), graph);
            int curScore = child.members;
            int res = parents.length -child.members - 1;
            if (res > 0) curScore *= res;
            int curMembers = child.members + 1;

            int numberOfHighest = 0;
            long maxScore = Math.max(curScore, child.maxScore);
            if (maxScore == child.maxScore) numberOfHighest += child.numberOfNodesHighest;
            if (maxScore == curScore) numberOfHighest++;
            return new Info(curMembers, maxScore, numberOfHighest);
        }
        return new Info(0, 0, 0);
    }
}
