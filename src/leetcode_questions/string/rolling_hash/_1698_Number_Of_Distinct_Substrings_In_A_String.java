package leetcode_questions.string.rolling_hash;

import java.util.HashSet;
import java.util.Set;

public class _1698_Number_Of_Distinct_Substrings_In_A_String {
    public int countDistinct(String s) {
        Set<Long> set = new HashSet<>();
        int N = s.length();

        int count = 0;
        for (int len = 1; len <= N; len++) {
            long power = 1;
            for (int i = 0; i < len - 1; i++) {
                power *= 26;
            }
            long hash = 0;
            for (int i = 0; i < N; i++) {
                if (i >= len) {
                    hash -= (s.charAt(i - len) - 'a') * power;
                }
                hash = hash * 26 + (s.charAt(i) - 'a');
                if (i >= len - 1) set.add(hash);
            }
            count += set.size();
            set.clear();
        }
        return count;
    }
}
