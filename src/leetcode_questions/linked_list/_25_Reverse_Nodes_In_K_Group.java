package leetcode_questions.linked_list;

import java.util.List;

public class _25_Reverse_Nodes_In_K_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode curNode = dummy.next;
        boolean hasEnd = false;

        while (curNode != null) {
            ListNode nextNode = curNode;
            for (int i = 0; i < k; i++) {
                if (nextNode == null) {
                    hasEnd = true;
                    break;
                }
                nextNode = nextNode.next;
            }

            if (hasEnd) {
                prevNode.next = curNode;
                return dummy.next;
            }

            else {
                reverse(curNode, prevNode, k);
                prevNode = curNode;
                curNode = nextNode;
            }
        }
        return dummy.next;
    }

    private void reverse(ListNode first, ListNode prevNode, int k) {
        ListNode curNode = first;
        first = first.next;
        curNode.next = null;
        ListNode temp;

        while (k > 1) {
            temp = first.next;
            first.next = curNode;
            curNode = first;
            first = temp;
            k--;
        }
        prevNode.next = curNode;
    }
}
