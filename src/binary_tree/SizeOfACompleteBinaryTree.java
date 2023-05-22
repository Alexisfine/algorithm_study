package binary_tree;

public class SizeOfACompleteBinaryTree {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int val) {
            this.value = val;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) return 0;
        return bs(head, 1, largestLeftDepth(head, 1));
    }

    public static int bs(Node node, int level, int h) {
        if (level == h) return 1;
        if (largestLeftDepth(node.right, level + 1) == h) {
            // left tree is full
            // add 2^(h-level) - 1 + 1
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    public static int largestLeftDepth(Node node, int level) {
        while (node != null) {
            node = node.left;
            level++;
        }
        return level - 1;
    }
}
