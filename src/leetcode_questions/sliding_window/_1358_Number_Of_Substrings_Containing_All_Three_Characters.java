package leetcode_questions.sliding_window;

import java.util.Arrays;

public class _1358_Number_Of_Substrings_Containing_All_Three_Characters {
    public int numberOfSubstrings(String s) {
        int[] lastIndexMap = new int[3];
        Arrays.fill(lastIndexMap, -1);
        int res = 0;
        int N = s.length();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (curChar == 'a') lastIndexMap[0] = end;
            else if (curChar == 'b') lastIndexMap[1] = end;
            else lastIndexMap[2] = end;

            while (lastIndexMap[0] != -1 && lastIndexMap[1] != -1 && lastIndexMap[2] != -1) {
                res += N - end;
                char startChar = s.charAt(start);
                if (startChar == 'a' && lastIndexMap[0] == start) {
                    lastIndexMap[0] = -1;
                } else if (startChar == 'b' && lastIndexMap[1] == start) {
                    lastIndexMap[1] = -1;
                } else if (startChar == 'c' && lastIndexMap[2] == start) {
                    lastIndexMap[2] = -1;
                }
                start++;
            }
        }
        return res;
    }
}
