package leetcode_questions.bst;

import java.util.Stack;

public class _173_Binary_Search_Tree_Iterator {
    public class BSTIterator {
        TreeNode root;
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            this.root = root;
            this.stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            root = node.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
