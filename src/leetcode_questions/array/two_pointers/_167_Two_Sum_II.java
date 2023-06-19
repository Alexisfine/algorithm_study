package leetcode_questions.array.two_pointers;

public class _167_Two_Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                return res;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
