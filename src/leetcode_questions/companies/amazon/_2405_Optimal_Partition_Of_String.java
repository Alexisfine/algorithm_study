package leetcode_questions.companies.amazon;

import java.util.Arrays;

public class _2405_Optimal_Partition_Of_String {
    public int partitionString(String s) {
        boolean[] countMap = new boolean[26];
        int count = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (countMap[curChar - 'a']) {
                count++;
                Arrays.fill(countMap, false);
            }
            countMap[s.charAt(end) - 'a'] = true;
        }
        return count + 1;
    }
}
