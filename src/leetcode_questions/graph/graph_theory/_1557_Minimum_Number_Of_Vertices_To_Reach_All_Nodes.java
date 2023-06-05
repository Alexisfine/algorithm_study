package leetcode_questions.graph.graph_theory;

import java.util.*;

public class _1557_Minimum_Number_Of_Vertices_To_Reach_All_Nodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> hasInDegree = new HashSet<>();
        for (List<Integer> edge : edges) {
            hasInDegree.add(edge.get(1));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasInDegree.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
