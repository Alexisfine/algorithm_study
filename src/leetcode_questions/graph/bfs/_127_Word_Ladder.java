package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _127_Word_Ladder {
    // Time: O(M ^ 2 * N)
    // Space: O(M ^2 * N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return steps;
                char[] chs = cur.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (int k = 97; k <= 122; k++) {
                        chs[j] = (char) k;
                        String newStr = new String(chs);
                        if (wordSet.contains(newStr) && !visited.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                    chs[j] = old;
                }
            }
            steps++;
        }
        return 0;
    }
}
