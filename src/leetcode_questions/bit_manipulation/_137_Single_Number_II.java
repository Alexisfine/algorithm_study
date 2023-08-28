package leetcode_questions.bit_manipulation;

public class _137_Single_Number_II {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (x >> i) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (bits[i] % 3) << i;
        }
        return res;
    }
}
