package leetcode_questions.string;

public class _28_strStr {
    // Time: O(m+n)
    // Space: O(n)
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() < 1 || haystack.length() < needle.length()) {
            return -1;
        }
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (i2 > 0) {
                i2 = next[i2];
            } else {
                i1++;
            }
            if (i2 == str2.length) {
                return i1 - str2.length;
            }
        }
        return -1;
    }

    private static int[] getNextArray(char[] m) {
        if (m.length == 1) return new int[]{-1};
        int[] next = new int[m.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (m[i - 1] == m[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
