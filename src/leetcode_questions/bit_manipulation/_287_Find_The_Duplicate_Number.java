package leetcode_questions.bit_manipulation;

public class _287_Find_The_Duplicate_Number {
    public static int findDuplicate(int[] nums) {
        int runner = 0;
        int chaser = 0;
        while (true) {
            chaser = nums[chaser];
            runner = nums[nums[runner]];
            if (chaser == runner) break;
        }
        int chaser2 = 0;
        while (true) {
            chaser2 = nums[chaser2];
            chaser = nums[chaser];
            if (chaser2 == chaser) break;
        }
        return chaser;
    }


}
