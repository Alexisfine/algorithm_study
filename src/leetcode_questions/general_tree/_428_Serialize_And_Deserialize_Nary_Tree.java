package leetcode_questions.general_tree;

import java.util.LinkedList;
import java.util.List;

public class _428_Serialize_And_Deserialize_Nary_Tree {
    final String N = "N";
    final String COMMA = ",";
    StringBuilder sb;
    // Encodes a tree to a single algo_questions.string.
    public String serialize(Node root) {
        if (root == null) return N;
        this.sb = new StringBuilder();
        encode(root);
        int size = sb.length();
        sb.deleteCharAt(size - 1);
        return new String(sb);
    }

    private void encode(Node node) {
        sb.append(node.val);
        sb.append(COMMA);
        List<Node> children = node.children;
        if (children.size() > 0) {
            for (Node child : children) {
                encode(child);
            }
        }
        sb.append(N);
        sb.append(COMMA);
    }

    String[] dataArr;
    int index;

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        this.dataArr = data.split(",");
        this.index = 0;
        return decode();
    }

    private Node decode() {
        String curItem = dataArr[index++];
        if (curItem.equals(N)) return null;
        List<Node> children = new LinkedList<>();
        while (index < dataArr.length) {
            Node child = decode();
            if (child != null) {
                children.add(child);
            } else break;
        }
        return new Node(Integer.parseInt(curItem), children);
    }
}
