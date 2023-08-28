package leetcode_questions.binary_tree;

public class _687_Longest_Univalue_Path {
    private class Info {
        int longestPathLength;
        int longestPathNum;
        int currentPathLength;
        int currentPathNum;
        public Info(int longestPathLength, int longestPathNum,
                    int currentPathLength, int currentPathNum) {
            this.longestPathLength = longestPathLength;
            this.longestPathNum = longestPathNum;
            this.currentPathLength = currentPathLength;
            this.currentPathNum = currentPathNum;
        }
    }
    public int longestUnivaluePath(TreeNode root) {
        Info info = process(root);
        return Math.max(Math.max(info.currentPathLength, info.longestPathLength) - 1, 0);
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, Integer.MAX_VALUE,
                    0, Integer.MAX_VALUE);
        }

        Info left = process(node.left);
        Info right = process(node.right);
        int longestPathLength = 1;
        int longestPathNum = node.val;
        int currentPathLength = 1;
        int currentPathNum = node.val;

        if (longestPathLength < left.longestPathLength) {
            longestPathLength = left.longestPathLength;
            longestPathNum = left.longestPathNum;
        }
        if (longestPathLength < right.longestPathLength) {
            longestPathLength = right.longestPathLength;
            longestPathNum = right.longestPathNum;
        }

        if (left.currentPathNum == node.val) {
            currentPathLength += left.currentPathLength;
            if (longestPathLength < currentPathLength) {
                longestPathLength = currentPathLength;
                longestPathNum = currentPathNum;
            }
        }
        if (right.currentPathNum == node.val) {
            currentPathLength = Math.max(currentPathLength, 1 + right.currentPathLength);
            if (longestPathLength < currentPathLength) {
                longestPathLength = currentPathLength;
                longestPathNum = currentPathNum;
            }
        }

        if (left.currentPathNum == right.currentPathNum && node.val == left.currentPathNum) {
            if (left.currentPathLength + right.currentPathLength + 1 > longestPathLength) {
                longestPathLength = left.currentPathLength + right.currentPathLength + 1;
                longestPathNum = node.val;
            }
        }
        return new Info(longestPathLength, longestPathNum, currentPathLength, currentPathNum);
    }
}
