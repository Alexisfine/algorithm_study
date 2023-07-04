package leetcode_questions.trie;

public class _208_Implement_Trie {
    private class Node {
        char letter;
        int leaf;
        Node[] children;
        public Node(char letter) {
            this.letter = letter;
            this.leaf = 0;
            children = new Node[26];
        }
    }
    class Trie {
        Node root;

        public Trie() {
            root = new Node(' ');
        }

        public void insert(String word) {
            Node curNode = root;
            for (int cur = 0; cur < word.length(); cur++) {
                Node nextNode = curNode.children[word.charAt(cur) - 'a'];
                if (nextNode == null) {
                    curNode.children[word.charAt(cur) - 'a'] = new Node(word.charAt(cur));
                }
                curNode = curNode.children[word.charAt(cur) - 'a'];
                if (cur == word.length() - 1) curNode.leaf++;
            }
        }

        public boolean search(String word) {
            Node curNode = root;
            for (int cur = 0; cur < word.length(); cur++) {
                Node nextNode = curNode.children[word.charAt(cur) - 'a'];
                if (nextNode == null) return false;
                curNode = nextNode;
            }
            return curNode.leaf > 0;
        }

        public boolean startsWith(String prefix) {
            Node curNode = root;
            for (int cur = 0; cur < prefix.length(); cur++) {
                Node nextNode = curNode.children[prefix.charAt(cur) - 'a'];
                if (nextNode == null) return false;
                curNode = nextNode;
            }
            return true;
        }
    }
}
