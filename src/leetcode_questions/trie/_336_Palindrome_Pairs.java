package leetcode_questions.trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _336_Palindrome_Pairs {
    private class Node {
        char letter;
        boolean isLeaf;
        int index;
        Node[] children;
        public Node(char letter) {
            this.letter = letter;
            isLeaf = false;
            children = new Node[26];
            index = 0;
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Node root = new Node(' ');
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() < 1) continue;
            Node curNode = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                if (curNode.children[word.charAt(j) - 'a'] == null) {
                    curNode.children[word.charAt(j) - 'a'] = new Node(word.charAt(j));
                }
                curNode = curNode.children[word.charAt(j) - 'a'];
            }
            curNode.isLeaf = true;
            curNode.index = i;
        }


        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                for (int j = 0; j < words.length; j++) {
                    List<Character> list = new ArrayList<>();
                    for (int k = 0; k < words[j].length(); k++) {
                        list.add(words[j].charAt(k));
                    }
                    if (i != j && isPalindrome(list)) {
                        res.add(List.of(i, j));
                        res.add(List.of(j, i));
                    }
                }
                continue;
            }
            int index = 0;
            Node curNode = root;
            List<Character> curList = new LinkedList<>();
            for (int j = 0; j < word.length(); j++) curList.add(word.charAt(j));

            for (; index < word.length(); index++) {
                char ch = word.charAt(index);
                curNode = curNode.children[ch - 'a'];
                if (curNode == null) {
                    break;
                }
                if (!curList.isEmpty()) curList.remove(0);
                if (curNode.isLeaf && curNode.index != i && isPalindrome(curList)) {
                    res.add(List.of(i, curNode.index));
                }
            }
            if (curNode == null) continue;
            for (int j = 0; j < 26; j++) {
                dfs(i, curNode.children[j], new LinkedList<>(), res);
            }
        }
        return res;
    }

    private void dfs(int index, Node node, List<Character> curStr, List<List<Integer>> res) {
        if (node == null) return;
        curStr.add(node.letter);

        if (node.isLeaf) {
            if (isPalindrome(curStr)) {
                res.add(List.of(index, node.index));
            }
        }
        for (int i = 0; i < 26; i++) {
            dfs(index, node.children[i], curStr, res);
        }
        curStr.remove(curStr.size() - 1);
    }
    private boolean isPalindrome(List<Character> str) {
        int lo = 0;
        int hi = str.size() - 1;
        while (lo < hi) {
            if (!str.get(lo++).equals(str.get(hi--))) {
                return false;
            }
        }
        return true;
    }
}
