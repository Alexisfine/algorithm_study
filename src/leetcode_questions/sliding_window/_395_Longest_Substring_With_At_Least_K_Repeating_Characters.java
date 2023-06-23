package leetcode_questions.sliding_window;

public class _395_Longest_Substring_With_At_Least_K_Repeating_Characters {
    public static int longestSubstring(String s, int k) {
        int[] originalMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            originalMap[s.charAt(i) - 'a']++;
        }

        int start = 0;
        int maxLen = 0;
        int elements = 0;
        int elementsSatisfied = 0;
        int[] curMap = new int[26];
        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (originalMap[curChar - 'a'] < k) {
                while (start < end) {
                    char startChar = s.charAt(start);
                    originalMap[startChar - 'a']--;
                    curMap[startChar - 'a']--;
                    if (curMap[startChar - 'a'] == 0) {
                        elements--;
                    }
                    if (elements <= elementsSatisfied) {
                        maxLen = Math.max(maxLen, end - start);
                    }
                    start++;
                }
                elements = 0;
                elementsSatisfied = 0;
                start = end + 1;
            } else {
                if (curMap[curChar - 'a'] == 0) elements++;
                curMap[curChar - 'a']++;
                if (curMap[curChar - 'a'] == k) {
                    elementsSatisfied++;
                }
                if (elements == elementsSatisfied) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

}
