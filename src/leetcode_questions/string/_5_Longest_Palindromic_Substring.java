package leetcode_questions.string;

public class _5_Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int maxLen = Integer.MIN_VALUE;
        int maxCenter = 0;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(R - i, pArr[2 * C - i]) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) pArr[i]++;
                else break;
            }
            if (maxLen < pArr[i]) {
                maxLen = pArr[i];
                maxCenter = i;
            }

            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
        }

        int start;
        if (maxCenter % 2 == 0 && maxLen % 2 == 1 && maxCenter < maxLen) start = maxCenter - maxLen + 1;
        else start = maxCenter - maxLen;
        return s.substring(start, maxLen - 2 + start);
    }


    private static char[] manacherString(String s) {
        char[] str = s.toCharArray();
        char[] chs = new char[2 * str.length + 1];
        for (int i = 0; i < str.length; i++) {
            chs[2 * i] = '#';
            chs[2 * i + 1] = str[i];
        }
        chs[chs.length - 1] = '#';
        return chs;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("caba"));
    }
}
