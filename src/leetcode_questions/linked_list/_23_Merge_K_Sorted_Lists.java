package leetcode_questions.linked_list;

import java.util.PriorityQueue;

public class _23_Merge_K_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            runner.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            runner = runner.next;
        }

        return dummy.next;
    }
}
