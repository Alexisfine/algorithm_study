package leetcode_questions.binary_tree;

public class _297_Serialize_And_Deserialize_Binary_Tree {
    int index;
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(',');
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        this.index = 0;
        return dfs(values);

    }

    private TreeNode dfs(String[] values) {
        if (values[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index++]));
        node.left = dfs(values);
        node.right = dfs(values);
        return node;
    }
}
