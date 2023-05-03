package trie;

public class Trie {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;
        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) return;
        char[] chs = word.toCharArray();
        TrieNode node = this.root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) node.nexts[index] = new TrieNode();
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) == 0) return;
        char[] chs = word.toCharArray();
        TrieNode node = this.root;
        node.pass--;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (--node.nexts[index].pass == 0) {
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    public int search(String word) {
        if (word == null) return 0;
        char[] chs = word.toCharArray();
        TrieNode node = this.root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            if (node == null) return 0;
            index = chs[i] - 'a';
            node = node.nexts[index];
        }
        return node.end;
    }
}
