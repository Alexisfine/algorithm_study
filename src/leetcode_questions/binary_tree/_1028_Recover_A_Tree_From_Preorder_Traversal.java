package leetcode_questions.binary_tree;

import java.util.Stack;

public class _1028_Recover_A_Tree_From_Preorder_Traversal {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < traversal.length();) {
            int level = 0;
            while (traversal.charAt(i) == '-') {
                i++;
                level++;
            }
            int val = 0;
            while (i < traversal.length() && traversal.charAt(i) != '-') {
                val = val * 10 + traversal.charAt(i) - '0';
                i++;
            }

            TreeNode node = new TreeNode(val);
            if (stack.isEmpty()) {
                stack.push(node);
                continue;
            }
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode parent = stack.peek();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            stack.push(node);
        }

        while (stack.size() > 1) stack.pop();
        return stack.peek();
    }

}
