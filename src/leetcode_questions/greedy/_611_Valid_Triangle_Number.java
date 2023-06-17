package leetcode_questions.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _611_Valid_Triangle_Number {
    // Binary Search Approach
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);

        int triangleNumbers = 0;
        for (int lo = 0; lo < nums.length; lo++) {
            for (int hi = nums.length - 1; hi > lo + 1; hi--) {
                int leftBound = lo + 1;
                int rightBound = hi - 1;
                int currentBest = hi;
                while (leftBound <= rightBound) {
                    int mid = leftBound + (rightBound - leftBound) / 2;
                    int sum = nums[lo] + nums[mid];
                    if (sum > nums[hi]) {
                        currentBest = mid;
                        rightBound = mid - 1;
                    } else {
                        leftBound = mid + 1;
                    }
                }
                triangleNumbers += hi - currentBest;
            }
        }
        return triangleNumbers;
    }

    // Greedy Approach
    public int triangleNumber2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}
