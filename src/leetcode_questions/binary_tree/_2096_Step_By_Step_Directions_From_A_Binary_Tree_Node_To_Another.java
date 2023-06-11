package leetcode_questions.binary_tree;

import java.util.*;

public class _2096_Step_By_Step_Directions_From_A_Binary_Tree_Node_To_Another {
    private record Info(TreeNode node, char direction) {}

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return null;
        if (startValue == destValue) return "";
        Map<Integer, List<Info>> graph = new HashMap<>();
        if (root.left != null) {
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.get(root.val).add(new Info(root.left, 'L'));
            dfs(root, root.left, graph);
        }
        if (root.right != null) {
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.get(root.val).add(new Info(root.right, 'R'));
            dfs(root, root.right, graph);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(startValue);
        return findPath(startValue, destValue, new StringBuilder(), visited, graph);
    }

    private String findPath(int current, int target, StringBuilder sb,
                            Set<Integer> visited, Map<Integer, List<Info>> graph) {
        if (current == target) {
            return new String(sb);
        }

        if (graph.containsKey(current)) {
            for (Info next : graph.get(current)) {
                if (visited.contains(next.node.val)) continue;
                visited.add(next.node.val);
                sb.append(next.direction);
                String res = findPath(next.node.val, target, sb, visited, graph);
                if (res != null) return res;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return null;
    }



    private void dfs(TreeNode prevNode, TreeNode curNode, Map<Integer, List<Info>> graph) {
        if (curNode == null) return;
        graph.put(curNode.val, new ArrayList<>(3));
        graph.get(curNode.val).add(new Info(prevNode, 'U'));
        if (curNode.left != null) {
            graph.get(curNode.val).add(new Info(curNode.left, 'L'));
            dfs(curNode, curNode.left, graph);
        }
        if (curNode.right != null) {
            graph.get(curNode.val).add(new Info(curNode.right, 'R'));
            dfs(curNode, curNode.right, graph);
        }
    }
}
