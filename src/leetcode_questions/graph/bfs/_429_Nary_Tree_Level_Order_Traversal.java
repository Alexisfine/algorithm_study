package leetcode_questions.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_Nary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
