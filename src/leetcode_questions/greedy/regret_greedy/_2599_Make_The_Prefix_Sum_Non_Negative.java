package leetcode_questions.greedy.regret_greedy;

import java.util.PriorityQueue;

public class _2599_Make_The_Prefix_Sum_Non_Negative {
    public int makePrefSumNonNegative(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long preSum = 0;
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                preSum += nums[i];
            } else if (preSum + nums[i] >= 0) {
                preSum += nums[i];
                pq.offer(nums[i]);
            } else {
                preSum += nums[i];
                pq.offer(nums[i]);
                preSum -= pq.poll();
                operations++;
            }
        }
        return operations;
    }

    /*
    X X X X  X   X
    5 2 3 4 -13 -4

    1. x>=0 => sum+=x
    2. x<0 && sum+x >= 0 => sum+=x
    3. x<0 && sum+x < 0 => => throw the largest negative

     */
}
