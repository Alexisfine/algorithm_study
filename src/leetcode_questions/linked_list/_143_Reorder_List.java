package leetcode_questions.linked_list;

import java.util.Arrays;

public class _143_Reorder_List {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode runner = head;
        ListNode chaser = head;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            chaser = chaser.next;
        }
        // Move chaser to 2nd half
        ListNode temp = chaser;
        chaser = chaser.next;
        temp.next = null;
        if (runner.next != null) runner = runner.next;

        ListNode curNode = chaser;
        chaser = chaser.next;
        curNode.next = null;

        while (chaser != null) {
            temp = chaser.next;
            chaser.next = curNode;
            curNode = chaser;
            chaser = temp;
        }

        ListNode frontNode = head;
        ListNode secondFrontNode = runner;
        while (secondFrontNode != null) {
            temp = frontNode.next;
            ListNode tempSecondNode = secondFrontNode.next;
            frontNode.next = secondFrontNode;
            secondFrontNode.next = temp;
            secondFrontNode = tempSecondNode;
            frontNode = temp;
        }
    }
}
