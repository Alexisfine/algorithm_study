package leetcode_questions.binary_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _2509_Cycle_Length_Queries_In_A_Tree {
    TreeMap<Integer, Integer> nodeLevelMap;

    // Time: O(logN * Q)
    public int[] cycleLengthQueries(int n, int[][] queries) {
        initializeNodeLevelMap();

        int[] res = new int[queries.length];
        int counter = 0;

        for (int[] query : queries) {
            int nodeA = query[0];
            int nodeB = query[1];
            int levelA = nodeLevelMap.get(nodeLevelMap.floorKey(nodeA));
            int levelB = nodeLevelMap.get(nodeLevelMap.floorKey(nodeB));
            int distance = 1;
            while (levelA > levelB) {
                nodeA = nodeA % 2 == 1 ? nodeA - 1 : nodeA;
                nodeA /= 2;
                levelA--;
                distance++;
            }
            while (levelB > levelA) {
                nodeB = nodeB % 2 == 1 ? nodeB - 1 : nodeB;
                nodeB /= 2;
                levelB--;
                distance++;
            }

            while (nodeA != nodeB) {
                nodeA = nodeA % 2 == 1 ? nodeA - 1 : nodeA;
                nodeB = nodeB % 2 == 1 ? nodeB - 1 : nodeB;
                nodeA /= 2;
                nodeB /= 2;
                distance += 2;
                levelA--;
                levelB--;
            }
            res[counter++] = distance;
        }
        return res;
    }

    private void initializeNodeLevelMap() {
        this.nodeLevelMap = new TreeMap<>();
        int cur = 1;
        for (int i = 0; i <= 30; i++) {
            nodeLevelMap.put(cur, i);
            cur *= 2;
        }
    }
}
