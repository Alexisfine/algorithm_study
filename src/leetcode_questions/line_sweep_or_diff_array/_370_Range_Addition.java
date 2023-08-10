package leetcode_questions.line_sweep_or_diff_array;

public class _370_Range_Addition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length + 1];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int change = updates[i][2];
            diff[start] += change;
            diff[end + 1] -= change;
        }
        int[] res = new int[length];
        int cur = 0;
        for (int i = 0; i < length; i++) {
            cur += diff[i];
            res[i] = cur;
        }
        return res;
    }

    /*
    [3,5] increase by 2
    X X X X X X X X X X
    diff[]: diff[3] += 2, diff[6] -= 2
     */

}
