package leetcode_questions.trie;

public class _1166_Design_File_System {
    private class Node {
        char letter;
        Node[] children;
        boolean hasEnd;
        int value;
        public Node(char letter) {
            this.letter = letter;
            children = new Node[27];
            hasEnd = false;
            value = 0;
        }
    }
    class FileSystem {
        Node root;

        public FileSystem() {
            root = new Node(' ');
        }

        public boolean createPath(String path, int value) {
            int N = path.length();
            Node curNode = root;
            int count = 0;
            int curCount = 0;
            for (int i = 0; i < N; i++) {
                if (path.charAt(i) == '/') count++;
            }
            for (int i = 0; i < N; i++) {
                char curChar = path.charAt(i);
                Node nextNode = null;
                if (curChar == '/') {
                    if (curCount > 0 && !curNode.hasEnd) return false;
                    nextNode = curNode.children[26];
                    curCount++;
                }
                else nextNode = curNode.children[curChar - 'a'];

                if (nextNode == null) {
                    if (curCount < count) return false;
                    curNode.children[curChar == '/' ? 26 : curChar - 'a'] = new Node(curChar);
                }
                curNode = curNode.children[curChar == '/' ? 26 : curChar - 'a'];
            }

            if (curNode.hasEnd) return false;

            curNode.hasEnd = true;
            curNode.value = value;
            return true;
        }

        public int get(String path) {
            int N = path.length();
            Node curNode = root;
            for (int i = 0; i < N; i++) {
                char curChar = path.charAt(i);
                if (curChar == '/') curNode = curNode.children[26];
                else curNode = curNode.children[curChar - 'a'];
                if (curNode == null) return -1;
            }
            if (!curNode.hasEnd) return -1;
            return curNode.value;
        }
    }
}
