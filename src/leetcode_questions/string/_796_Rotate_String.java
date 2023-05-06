package leetcode_questions.string;

public class _796_Rotate_String {

    // Time: O(N)
    // Space: O(N)
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s = s + s;
        int[] next = getNextArray(goal);
        int i1 = 0;
        int i2 = 0;
        while (i1 < s.length() && i2 < goal.length()) {
            if (s.charAt(i1) == goal.charAt(i2)) {
                i1++;
                i2++;
            } else if (i2 > 0) i2 = next[i2];
            else i1++;
        }
        return i2 == goal.length();
    }

    private static int[] getNextArray(String goal) {
        if (goal.length() == 1) return new int[]{-1};
        int[] next = new int[goal.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (goal.charAt(i-1) == goal.charAt(cn)) {
                next[i++] = ++cn;
            } else if (cn > 0) cn = next[cn];
            else next[i++] = 0;
        }
        return next;
    }
}
