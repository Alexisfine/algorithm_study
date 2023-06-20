package leetcode_questions.linked_list;

public class _1721_Swapping_Nodes_In_A_Linked_List {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curNode = head;
        for (int i = 0; i < k - 1; i++) {
            curNode = curNode.next;
        }
        ListNode left = head;
        ListNode right = curNode;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        int val = curNode.val;
        curNode.val = left.val;
        left.val = val;
        return head;
    }
}
