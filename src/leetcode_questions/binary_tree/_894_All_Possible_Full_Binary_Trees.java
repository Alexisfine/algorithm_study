package leetcode_questions.binary_tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _894_All_Possible_Full_Binary_Trees {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();
    // Time: O(2^N) (Not important)
    public List<TreeNode> allPossibleFBT(int n) {

        if (n % 2 == 0) return new ArrayList<>();
        return process(n);
    }

    private List<TreeNode> process(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return List.of(new TreeNode(0));
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int leftNum = i;
            int rightNum = n - i - 1;
            List<TreeNode> left = process(leftNum);
            List<TreeNode> right = process(rightNum);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(0, l, r);
                    res.add(node);
                }
            }
        }
        dp.put(n, res);
        return res;
    }
}
