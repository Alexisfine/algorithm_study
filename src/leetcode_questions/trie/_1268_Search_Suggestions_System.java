package leetcode_questions.trie;

import java.util.ArrayList;
import java.util.List;

public class _1268_Search_Suggestions_System {
    private class Node {
        char letter;
        Node[] children;
        boolean hasEnded;
        public Node(char letter) {
            this.letter = letter;
            children = new Node[26];
            hasEnded = false;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node(' ');
        for (var product : products) {
            Node curNode = root;
            for (var ch : product.toCharArray()) {
                if (curNode.children[ch - 'a'] == null) {
                    curNode.children[ch - 'a'] = new Node(ch);
                }
                curNode = curNode.children[ch - 'a'];
            }
            curNode.hasEnded = true;
        }

        List<List<String>> res = new ArrayList<>();
        Node curNode = root;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (var ch : searchWord.toCharArray()) {
            List<String> list = new ArrayList<>();
            if (flag) {
                res.add(list);
                continue;
            }
            curNode = curNode.children[ch - 'a'];
            if (curNode == null) {
                res.add(list);
                flag = true;
                continue;
            }

            Node tempNode = curNode;
            dfs(tempNode, sb, list);
            res.add(list);

            sb.append(ch);
        }
        return res;
    }

    private void dfs(Node node, StringBuilder sb, List<String> list) {
        if (list.size() >= 3) return;
        if (node == null) return;
        sb.append(node.letter);
        if (node.hasEnded) {
            list.add(new String(sb));
        }
        for (int i = 0; i < 26 && list.size() < 3; i++) {
            dfs(node.children[i], sb, list);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

}
