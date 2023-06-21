package leetcode_questions.linked_list;

public class _109_Convert_Sorted_List_To_Binary_Search_Tree {
    private class Info {
        ListNode leftFirst;
        ListNode rightFirst;
        TreeNode treeNode;
        public Info(ListNode leftFirst, ListNode rightFirst, TreeNode treeNode) {
            this.leftFirst = leftFirst;
            this.rightFirst = rightFirst;
            this.treeNode = treeNode;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head);
    }

    private TreeNode buildBST(ListNode head) {
        Info info = findMidPoint(head);
        TreeNode node = info.treeNode;
        if (node == null) return null;
        node.left = buildBST(info.leftFirst);
        node.right = buildBST(info.rightFirst);
        return node;
    }

    private Info findMidPoint(ListNode node) {
        if (node == null) return new Info(null, null, null);
        if (node.next == null) {
            return new Info(null, null, new TreeNode(node.val));
        }
        if (node.next.next == null) {
            ListNode leftFirst = node;
            ListNode mid = node.next;
            node.next = null;
            return new Info(leftFirst, null, new TreeNode(mid.val));
        }

        ListNode preChaser = node;
        ListNode chaser = node.next;
        ListNode runner = node.next.next;
        while (runner != null && runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            chaser = chaser.next;
            preChaser = preChaser.next;
        }
        preChaser.next = null;
        ListNode rightFirst = chaser.next;
        chaser.next = null;
        return new Info(node, rightFirst, new TreeNode(chaser.val));
    }

    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
}
