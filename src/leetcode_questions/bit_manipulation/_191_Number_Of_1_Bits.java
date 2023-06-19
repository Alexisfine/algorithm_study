package leetcode_questions.bit_manipulation;

public class _191_Number_Of_1_Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
