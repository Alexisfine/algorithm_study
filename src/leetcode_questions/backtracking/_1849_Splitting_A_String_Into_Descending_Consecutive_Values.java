package leetcode_questions.backtracking;

public class _1849_Splitting_A_String_Into_Descending_Consecutive_Values {

    String s;
    int ASCII = 48;
    public boolean splitString(String s) {
        this.s = s;
        return process(0, 0, -1);
    }

    private boolean process(int index, long cur, long prev) {
        if (index == s.length()) {
            return prev >= 0 && prev - cur == 1;
        }

        cur = cur * 10 + s.charAt(index) - ASCII;

        if (prev != -1 && prev - cur <= 0) return false;

        // not split
        boolean notSplit = process(index + 1, cur, prev);

        // split
        boolean split = false;
        if (index < s.length() - 1 && (prev - cur == 1 || prev == -1)) split = process(index + 1, 0, cur);

        return notSplit || split;
    }

}
