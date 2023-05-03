package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseNonRecursive {
    private class Node<V> {
        V value;
        Node<V> left;
        Node<V> right;
    }

    public static void preOrderTraverse(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (! stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) stack.push(head.right);
                if (head.left != null) stack.push(head.left);
            }
        }
    }

    public static void postOrderTraverse(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) s1.push(head.left);
                if (head.right != null) s1.push(head.right);
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop());
            }
        }
    }

    public static void inOrderTraverse(Node head) {
        if (head != null) {
            StringBuilder sb = new StringBuilder();
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    head = head.right;
                }
            }
        }
    }

    public static void bfsTraverse(Node head) {
        if (head == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }
}
