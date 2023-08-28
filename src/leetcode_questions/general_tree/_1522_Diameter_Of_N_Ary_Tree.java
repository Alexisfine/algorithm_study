package leetcode_questions.general_tree;

import java.util.ArrayList;
import java.util.List;

public class _1522_Diameter_Of_N_Ary_Tree {
    private record Info(int maxDepth, int maxDiameter) {}
    public int diameter(Node root) {
        return dfs(root).maxDiameter;
    }

    private Info dfs(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }
        int maxDepth = 0;
        int secondMaxDepth = 0;
        int maxDiameter = 0;
        for (Node next : node.children) {
            Info info = dfs(next);
            maxDiameter = Math.max(maxDiameter, info.maxDiameter);
            if (maxDepth < info.maxDepth + 1) {
                secondMaxDepth = maxDepth;
                maxDepth = info.maxDepth + 1;
            } else if (secondMaxDepth < info.maxDepth + 1) {
                secondMaxDepth = info.maxDepth + 1;
            }
        }
        maxDiameter = Math.max(maxDiameter, maxDepth + secondMaxDepth);
        return new Info(maxDepth, maxDiameter);
    }


    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
