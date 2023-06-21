package leetcode_questions.linked_list;

import leetcode_questions.linked_list.ListNode;

public class _382_Linked_LIst_Random_Node {
    class Solution {
        ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            ListNode curNode = head;
            int scope = 1;
            int chosenValue = 0;
            while (curNode != null) {
                if (Math.random() < 1.0 / scope) {
                    chosenValue = curNode.val;
                }
                scope++;
                curNode = curNode.next;
            }
            return chosenValue;
        }
    }
}
