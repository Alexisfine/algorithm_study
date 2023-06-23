package leetcode_questions.linked_list;

public class _92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fromNode = null, prevNode = null, postNode = null;
        ListNode curNode = dummy;
        for (int i = 0; i <= right; i++) {
            if (i + 1 == left) {
                prevNode = curNode;
            }
            if (i == left) {
                fromNode = curNode;
            }
            if (i == right) {
                postNode = curNode.next;
            }
            curNode = curNode.next;
        }
        reverseLinkedList(fromNode, prevNode, postNode, right - left + 1);
        return dummy.next;
    }

    private void reverseLinkedList(ListNode fromNode, ListNode prevNode, ListNode postNode, int len) {
        ListNode curHead = fromNode;
        ListNode curNode = fromNode.next;
        curHead.next = postNode;
        ListNode temp;

        for (int i = 0; i < len - 1; i++) {
            temp = curNode.next;
            curNode.next = curHead;
            curHead = curNode;
            curNode = temp;
        }

        prevNode.next = curHead;
    }
}
