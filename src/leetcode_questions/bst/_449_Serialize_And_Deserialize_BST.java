package leetcode_questions.bst;

public class _449_Serialize_And_Deserialize_BST {
    int counter;
    public String serialize(TreeNode root) {
        if (root == null) return "N_";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append('_');
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("_");
        this.counter = 0;
        return buildBST(nodes);
    }

    private TreeNode buildBST(String[] nodes) {
        if (nodes[counter].equals("N")) {
            counter++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[counter++]));
        node.left = buildBST(nodes);
        node.right = buildBST(nodes);
        return node;
    }
}
