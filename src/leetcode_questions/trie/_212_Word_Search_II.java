package leetcode_questions.trie;

import java.util.ArrayList;
import java.util.List;

public class _212_Word_Search_II {
    private class Node {
        char letter;
        boolean hasLeaf;
        Node[] children;
        public Node(char letter) {
            this.letter = letter;
            hasLeaf = false;
            children = new Node[26];
        }
    }

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node(' ');
        for (var word : words) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                if (curNode.children[word.charAt(i) - 'a'] == null) {
                    curNode.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
                curNode = curNode.children[word.charAt(i) - 'a'];
            }
            curNode.hasLeaf = true;
        }
        int M = board.length;
        int N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(board, i, j, root, res, new StringBuilder(), visited);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, Node node, List<String> res,
                     StringBuilder curStr, boolean[][] visited) {
        if (node.children[board[i][j] - 'a'] == null) return;
        node = node.children[board[i][j] - 'a'];
        curStr.append(board[i][j]);
        visited[i][j] = true;

        if (node.hasLeaf) {
            node.hasLeaf = false;
            res.add(new String(curStr));
        }

        for (var dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
                continue;
            }
            dfs(board, x, y, node, res, curStr, visited);
        }
        curStr.deleteCharAt(curStr.length() - 1);
        visited[i][j] = false;
    }
}
