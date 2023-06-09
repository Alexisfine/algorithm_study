package leetcode_questions.prefix_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _437_Path_Sum_III {
    // Prefix Sum
    int targetSum;
    private class Info {
        List<Long> sum;
        int paths;
        public Info(List<Long> sum, int paths) {
            this.sum = sum;
            this.paths = paths;
        }

    }
    // Normal Approach
    // Time: O(N^2)
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        this.targetSum = targetSum;
        Info info = process(root);
        return info.paths;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(new ArrayList<>(), 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int paths = 0;
        paths += leftInfo.paths;
        paths += rightInfo.paths;

        for (int i = 0; i < leftInfo.sum.size(); i++) {
            long newVal = leftInfo.sum.get(i) + node.val;
            leftInfo.sum.set(i, newVal);
            if (newVal == targetSum) paths++;
        }

        for (int i = 0; i < rightInfo.sum.size(); i++) {
            long newVal = rightInfo.sum.get(i) + node.val;
            rightInfo.sum.set(i, newVal);
            if (newVal == targetSum) paths++;
        }

        List<Long> newSum = new ArrayList<>();
        newSum.addAll(leftInfo.sum);
        newSum.addAll(rightInfo.sum);
        newSum.add((long) node.val);
        if (node.val == targetSum) paths++;

        return new Info(newSum, paths);
    }

    // Prefix Sum Approach
    // Time: O(N)
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> prefixMap = new HashMap<>();
        return process2(root, targetSum, 0, new HashMap<>());
    }

    private int process2(TreeNode node, int targetSum, long currSum, Map<Long, Integer> prefixMap) {
        if (node == null) return 0;
        int res = 0;

        currSum += node.val;
        if (currSum == targetSum) res++;
        long complement = currSum - targetSum;
        res += prefixMap.getOrDefault(complement, 0);
        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

        res += process2(node.left, targetSum, currSum, prefixMap);
        res += process2(node.right, targetSum, currSum, prefixMap);

        prefixMap.put(currSum, prefixMap.get(currSum) - 1);
        return res;
    }


}
