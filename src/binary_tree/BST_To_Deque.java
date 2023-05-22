package binary_tree;

public class BST_To_Deque {
    private static class Node {
        int value;
        Node left;
        Node right;
    }
    private static class Info {
        Node start;
        Node end;
        public Info(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Info process(Node node) {
        if (node == null) return new Info(null, null);
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        if (leftInfo.end != null) {
            leftInfo.end.right = node;
        }

        if (rightInfo.start != null) {
            rightInfo.start.left = node;
        }

        node.left = leftInfo.end;
        node.right = rightInfo.start;

        return new Info(
                leftInfo.start != null ? leftInfo.start : node,
                rightInfo.end != null ? rightInfo.end : node);
    }
}
