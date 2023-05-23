package string;

import java.util.List;

public class Manacher {
    public static int maxLcpsLength(String s) {
        if (s == null || s.length() < 1) return 0;
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1; // center
        int R = -1; // palindrome right boundary + 1
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) pArr[i]++;
                else break;
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;

    }

    private static char[] manacherString(String str) {
        // 1221 ~ #1#2#2#1#
        char[] charArr = str.toCharArray();
        char[] chs = new char[charArr.length * 2 + 1];
        for (int i = 0; i != chs.length; i++) {
            chs[i++] = '#';
            chs[i] = charArr[i - 1];
        }
        chs[chs.length - 1] = '#';
        return chs;
    }
}
