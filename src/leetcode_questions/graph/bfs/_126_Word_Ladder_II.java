package leetcode_questions.graph.bfs;

import java.util.*;

public class _126_Word_Ladder_II {
    // TLE
    public record Info(String current, LinkedHashSet<String> chain) {}
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<Info> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        boolean hasFound = false;

        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add(beginWord);
        Info info = new Info(beginWord, set);
        queue.offer(info);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Info chain = queue.poll();
                String cur = chain.current;
                if (cur.equals(endWord)) {
                    res.add(new ArrayList<>(chain.chain));
                    hasFound = true;
                }
                char[] chs = cur.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (int k = 97; k <= 122; k++) {
                        chs[j] = (char) k;
                        String newStr = new String(chs);
                        if (wordSet.contains(newStr) && !chain.chain.contains(newStr)) {
                            visited.add(newStr);
                            LinkedHashSet<String> nextChain = new LinkedHashSet<>(chain.chain);
                            nextChain.add(newStr);
                            queue.offer(new Info(newStr, nextChain));
                        }
                    }
                    chs[j] = old;
                }
            }
            if (hasFound) break;
        }
        return res;
    }
}
