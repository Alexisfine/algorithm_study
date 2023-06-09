package leetcode_questions.binary_tree;

public class _1530_Number_Of_Good_Lead_Nodes_Pairs {
    int distance;
    private class Info {
        int[] distanceMap;
        int pairs;
        public Info(int[] distanceMap, int pairs) {
            this.distanceMap = distanceMap;
            this.pairs = pairs;
        }
    }

    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        this.distance = distance;
        Info info = process(root);
        return info.pairs;
    }

    private Info process(TreeNode node) {
        int[] res = new int[distance + 1];

        if (node.left == null && node.right == null) {
            res[0] = 1;
            return new Info(res, 0);
        }

        if (node.left != null && node.right != null) {
            Info leftInfo = process(node.left);
            Info rightInfo = process(node.right);

            int pairs = leftInfo.pairs + rightInfo.pairs;
            for (int i = 0; i <= distance; i++) {
                for (int j = 0; i + j + 2 <= distance; j++) {
                    pairs += (leftInfo.distanceMap[i] * rightInfo.distanceMap[j]);
                }
            }
            for (int i = 0; i < distance; i++) {
                res[i + 1] += leftInfo.distanceMap[i];
                res[i + 1] += rightInfo.distanceMap[i];
            }
            return new Info(res, pairs);

        } else if (node.left != null) {
            Info leftInfo = process(node.left);
            for (int i = 0; i < distance; i++) {
                res[i + 1] += leftInfo.distanceMap[i];
            }
            return new Info(res, leftInfo.pairs);

        } else if (node.right != null) {
            Info rightInfo = process(node.right);
            for (int i = 0; i < distance; i++) {
                res[i + 1] += rightInfo.distanceMap[i];
            }
            return new Info(res, rightInfo.pairs);
        }

        return null;
    }
}
