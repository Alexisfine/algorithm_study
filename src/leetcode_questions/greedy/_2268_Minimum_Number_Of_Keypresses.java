package leetcode_questions.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _2268_Minimum_Number_Of_Keypresses {
    private class Pair {
        char letter;
        int count;
        public Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
    public int minimumKeypresses(String s) {
        int N = s.length();
        Pair[] countMap = new Pair[26];
        for (int i = 0; i < 26; i++) countMap[i] = new Pair((char) ('a' + i), 0);
        for (int i = 0; i < N; i++) {
            countMap[s.charAt(i) - 'a'].count++;
        }
        Arrays.sort(countMap, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count - o1.count;
            }
        });

        int res = 0;
        for (int i = 0; i < countMap.length; i++) {
            if (i < 9) {
                res += countMap[i].count;
            } else if (i < 18) {
                res += countMap[i].count * 2;
            } else {
                res += countMap[i].count * 3;
            }
        }
        return res;
    }
}
