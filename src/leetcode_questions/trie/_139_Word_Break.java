package leetcode_questions.trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_Word_Break {
    // Time: O(N^3)
    // Space: O(N)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int N = s.length();

        boolean[] dp = new boolean[N + 1];
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    private class Node {
        char letter;
        boolean hasEnd;
        Node[] children;
        public Node(char letter) {
            this.letter = letter;
            hasEnd = false;
            children = new Node[26];
        }
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        Node root = new Node(' ');
        for (var str : wordDict) {
            Node curNode = root;
            for (var ch : str.toCharArray()) {
                if (curNode.children[ch - 'a'] == null) {
                    curNode.children[ch - 'a'] = new Node(ch);
                }
                curNode = curNode.children[ch - 'a'];
            }
            curNode.hasEnd = true;
        }
        int[] cache = new int[s.length()];
        return dfs(s, 0, root, cache);
    }

    private boolean dfs(String s, int index, Node root, int[] cache) {
        if (index == s.length()) return true;
        if (cache[index] != 0) return cache[index] == 1;
        Node curNode = root;
        for (int i = index; i < s.length(); i++) {
            if (curNode.children[s.charAt(i) - 'a'] != null) {
                curNode = curNode.children[s.charAt(i) - 'a'];
                if (curNode.hasEnd && dfs(s, i + 1, root, cache)) {
                    cache[index] = 1;
                    return true;
                }
             } else break;
        }
        cache[index] = 2;
        return false;
    }
}
