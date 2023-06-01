package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _797_All_Paths_From_Source_To_Target {
    int[][] graph;
    HashSet<Integer> visited;
    List<List<Integer>> res;
    List<Integer> list;
    // Time: O(2 ^ N * N)

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        visited = new HashSet<>();
        res = new ArrayList<>();
        list = new ArrayList<>();
        process(0);
        return res;
    }

    private void process(int num) {
        if (num == graph.length - 1) {
            list.add(num);
            res.add(new ArrayList<>(list));
            list.remove(num);
            return;
        }

        visited.add(num);
        list.add(num);

        for (int next : graph[num]) {
            if (!visited.contains(next)) {
                process(next);
            }
        }

        visited.remove(num);
        list.remove(list.size() - 1);
    }
}
