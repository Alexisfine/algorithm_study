package leetcode_questions.linked_list;

import java.util.HashMap;
import java.util.Map;

public class _138_Copy_List_With_Random_Pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> oldToNewMap = new HashMap<>();
        Node curOldNode = head;
        while (curOldNode != null) {
            oldToNewMap.put(curOldNode, new Node(curOldNode.val));
            curOldNode = curOldNode.next;
        }

        curOldNode = head;
        Node curNewNode = null;
        while (curOldNode != null) {
            curNewNode = oldToNewMap.get(curOldNode);
            curNewNode.next = oldToNewMap.get(curOldNode.next);
            curNewNode.random = oldToNewMap.get(curOldNode.random);
            curOldNode = curOldNode.next;
        }
        return oldToNewMap.get(head);
    }
}
