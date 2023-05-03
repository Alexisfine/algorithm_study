package leetcode_questions.string;

public class _1392_Longest_Happy_Prefix {
    public String longestPrefix(String s) {
        if (s == null || s.length() < 1) return "";
        char[] str = s.toCharArray();
        int[] next = new int[str.length + 1];
        int i = 2;
        int cn = 0;
        next[0] = -1;
        next[1] = 0;
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return s.substring(0, next[next.length - 1]);
    }
}
