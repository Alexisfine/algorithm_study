package leetcode_questions.trie;

import java.util.ArrayList;
import java.util.List;

public class _140_Word_Break_II {
    private class Node {
        char letter;
        boolean hasEnded;
        Node[] children;
        public Node(char letter) {
            this.letter = letter;
            hasEnded = false;
            children = new Node[26];
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Node root = new Node(' ');
        for (var word : wordDict) {
            Node curNode = root;
            for (var ch : word.toCharArray()) {
                if (curNode.children[ch - 'a'] == null) {
                    curNode.children[ch - 'a'] = new Node(ch);
                }
                curNode = curNode.children[ch - 'a'];
            }
            curNode.hasEnded = true;
        }
        List<String> res = new ArrayList<>();
        List<String> curList = new ArrayList<>();
        int[] cache = new int[s.length()];
        dfs(0, s, root, res, curList, cache);
        return res;
    }

    private boolean dfs(int index, String s, Node root, List<String> res, List<String> curList, int[] cache) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : curList) {
                sb.append(str);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(new String(sb));
            return true;
        }

        if (cache[index] == 2) {
            return false;
        }

        boolean flag = false;
        Node curNode = root;
        for (int i = index; i < s.length(); i++) {
            if (curNode.children[s.charAt(i) - 'a'] != null) {
                curNode = curNode.children[s.charAt(i) - 'a'];
                if (curNode.hasEnded) {
                    curList.add(s.substring(index, i + 1));
                    if (dfs(i + 1, s, root, res, curList, cache)) {
                        flag = true;
                    }
                    curList.remove(curList.size() - 1);
                }
            } else {
                break;
            }
        }
        cache[index] = flag ? 1 : 2;
        return flag;
    }
}
