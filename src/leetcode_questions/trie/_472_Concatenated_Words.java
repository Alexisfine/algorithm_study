package leetcode_questions.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _472_Concatenated_Words {
    private class Node {
        char letter;
        Node[] children;
        boolean hasLeaf;
        int index;
        public Node(char letter) {
            this.letter = letter;
            children = new Node[26];
            hasLeaf = false;
            index = 0;
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Node root = new Node(' ');
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] visited = new int[word.length()];
            if (dfs(0, word, root, visited)) {
                res.add(word);
            }
            add(word, root);
        }
        return res;
    }

    private void add(String word, Node root) {
        Node curNode = root;
        for (int j = 0; j < word.length(); j++) {
            char curChar = word.charAt(j);
            if (curNode.children[curChar - 'a'] == null) {
                curNode.children[curChar - 'a'] = new Node(curChar);
            }
            curNode = curNode.children[curChar - 'a'];
        }
        curNode.hasLeaf = true;
    }

    private boolean dfs(int index, String word, Node node, int[] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (visited[index] == 1) return false;

        Node root = node;

        for (int i = index; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] != null) {
                node = node.children[word.charAt(i) - 'a'];
                if (node.hasLeaf && dfs(i + 1, word, root, visited)) {
                    return true;
                }
            } else {
                break;
            }
        }
        visited[index] = 1;
        return false;
    }
}
