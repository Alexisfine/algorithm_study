package leetcode_questions.linked_list;

public class _430_Flatten_A_Multilevel_Doubly_Linked_List {
    public Node flatten(Node head) {
        if (head == null) return null;
        process(head);
        return head;
    }

    private Node process(Node node) {
        if (node.next == null && node.child == null) {
            return node;
        }
        if (node.child == null) {
            return process(node.next);
        }
        if (node.next == null) {
            Node nextNode = node.child;
            node.child = null;
            node.next = nextNode;
            nextNode.prev = node;
            return process(nextNode);
        }

        Node prevNextNode = node.next;
        node.next = null;
        prevNextNode.prev = null;
        Node nextNode = node.child;
        node.child = null;
        node.next = nextNode;
        nextNode.prev = node;
        Node lastChildNode = process(nextNode);
        lastChildNode.next = prevNextNode;
        prevNextNode.prev = lastChildNode;
        return process(prevNextNode);
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
