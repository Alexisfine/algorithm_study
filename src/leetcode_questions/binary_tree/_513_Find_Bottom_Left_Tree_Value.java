package leetcode_questions.binary_tree;

public class _513_Find_Bottom_Left_Tree_Value {
    private class Info {
        int maxLevelLeft;
        int value;
        public Info(int maxLevelLeft, int value) {
            this.maxLevelLeft = maxLevelLeft;
            this.value = value;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        return process(root).value;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return null;
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        if (leftInfo == null && rightInfo == null) {
            return new Info(0, node.val);
        }

        if (leftInfo == null) {
            return new Info(rightInfo.maxLevelLeft + 1, rightInfo.value);
        }

        if (rightInfo == null) {
            return new Info(leftInfo.maxLevelLeft + 1, leftInfo.value);
        }

        int maxLevel = Math.max(leftInfo.maxLevelLeft, rightInfo.maxLevelLeft);
        int mostLeftValue = maxLevel == leftInfo.maxLevelLeft ?
                leftInfo.value : rightInfo.value;
        return new Info(maxLevel + 1, mostLeftValue);
    }
}
