package leetcode_questions.bfs;

import java.util.*;

public class _126_Word_Ladder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> nextWords = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);

        boolean flag = true;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) flag = false;
        }
        if (flag) wordList.add(beginWord);

        for (var s : wordList) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char originalChar = chs[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == originalChar) continue;
                    chs[i] = ch;
                    String nextStr = new String(chs);
                    if (wordSet.contains(nextStr)) {
                        nextWords.putIfAbsent(s, new ArrayList<>());
                        nextWords.get(s).add(nextStr);
                    }
                }
                chs[i] = originalChar;
            }
        }
        if (flag) wordList.remove(wordList.size() - 1);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> prevWords = new HashMap<>();
        int flag2 = 0;

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> newVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (!nextWords.containsKey(current)) continue;
                for (var nextWord : nextWords.get(current)) {
                    if (visited.contains(nextWord)) continue;
                    newVisited.add(nextWord);
                    prevWords.putIfAbsent(nextWord, new ArrayList<>());
                    prevWords.get(nextWord).add(current);

                    if (nextWord.equals(endWord)) flag2 = 1;
                }
            }
            if (flag2 == 1) break;
            for (var str : newVisited) {
                visited.add(str);
                queue.offer(str);
            }
            newVisited.clear();
        }


        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if (!nextWords.containsKey(endWord)) return res;
        if (!prevWords.containsKey(endWord)) return res;
        dfs(beginWord, endWord, path, prevWords, res);
        return res;
    }

    private void dfs(String beginWord, String curWord, List<String> path,
                     Map<String, List<String>> prevWords, List<List<String>> res) {
        if (curWord.equals(beginWord)) {
            path.add(0, curWord);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }
        path.add(0, curWord);
        for (var prevWord : prevWords.get(curWord)) {
            dfs(beginWord, prevWord, path, prevWords, res);
        }
        path.remove(0);
    }


    /*
    {A} => {B,D} => {C}
    prev[B] = A
    prev[D] = A
    prev[C] = {B,D}
     */
}
