package leetcode_questions.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _767_Reorganize_String {
    private class Pair {
        char letter;
        int times;
        public Pair(char letter, int times) {
            this.letter = letter;
            this.times = times;
        }
    }
    public String reorganizeString(String s) {
        int N = s.length();
        int[] letterCountMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterCountMap[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.times - a.times);
        for (int i = 0; i < letterCountMap.length; i++) {
            if (letterCountMap[i] != 0) {
                pq.offer(new Pair((char) ('a' + i), letterCountMap[i]));
            }
        }

        char[] chs = new char[N];
        int len = 0;
        Pair temp = null;
        while (len < N) {
            if (pq.isEmpty()) return "";
            Pair cur = pq.poll();
            chs[len++] = cur.letter;
            cur.times--;
            if (temp != null) {
                pq.offer(temp);
                temp = null;
            }
            if (cur.times > 0) {
                temp = cur;
            }
        }
        return new String(chs);
    }
}
