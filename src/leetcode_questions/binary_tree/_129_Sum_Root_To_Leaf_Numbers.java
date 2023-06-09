package leetcode_questions.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class _129_Sum_Root_To_Leaf_Numbers {
    // Time: O(N)
    // Space: O(N)
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<StringBuilder> res = process(root);
        int sum = 0;
        for (StringBuilder sb : res) {
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }

    private List<StringBuilder> process(TreeNode node) {
        List<StringBuilder> res = new ArrayList<>();
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(node.val);
            res.add(sb);
            return res;
        }

        if (node.left != null) {
            List<StringBuilder> leftRes = process(node.left);
            for (StringBuilder str : leftRes) {
                str.insert(0, node.val);
                res.add(str);
            }
        }

        if (node.right != null) {
            List<StringBuilder> rightRes = process(node.right);
            for (StringBuilder str : rightRes) {
                str.insert(0, node.val);
                res.add(str);
            }
        }

        return res;
    }

}
