package binary_tree;

public class TraverseRecursive {
    private class Node<V> {
        V value;
        Node<V> left;
        Node<V> right;
    }

    public static void recursiveTraverse(Node head) {
        if (head == null) return;
        recursiveTraverse(head.left);
        recursiveTraverse(head.right);
    }
}
