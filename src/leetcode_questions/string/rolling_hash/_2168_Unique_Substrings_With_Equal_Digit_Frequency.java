package leetcode_questions.string.rolling_hash;

import java.util.HashSet;
import java.util.Set;

public class _2168_Unique_Substrings_With_Equal_Digit_Frequency {
    public int equalDigitFrequency(String s) {
        Set<Long> set = new HashSet<>();
        int N = s.length();
        int base = 11;
        long modulo = (long) 1e9 + 7;
        for (int i = 0; i < N; i++) {
            long hash = 0;
            int[] count = new int[10];

            for (int j = i; j < N; j++) {
                hash = hash * base + (s.charAt(j) - '0' + 1);
                hash %= modulo;
                count[s.charAt(j) - '0']++;
                int freq = -1;
                boolean flag = true;
                for (int k = 0; k < 10; k++) {
                    if (count[k] == 0) continue;
                    if (freq == -1) freq = count[k];
                    else if (count[k] != freq){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    set.add(hash);
                }
            }
        }
        return set.size();
    }
}
