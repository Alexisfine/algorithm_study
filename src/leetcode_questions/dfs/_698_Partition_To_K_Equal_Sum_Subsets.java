package leetcode_questions.dfs;

import java.util.Arrays;

public class _698_Partition_To_K_Equal_Sum_Subsets {
    int partitionSum;
    int k;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        this.partitionSum = sum / k;
        this.k = k;
        this.visited = new boolean[nums.length];
        return dfs(nums, 0, 0, 0);
    }

    private boolean dfs(int[] nums, int index, int curSum, int partition) {
        if (partition == k) return true;
        if (curSum > partitionSum) return false;
        if (curSum == partitionSum) {
            return dfs(nums, 0, 0, partition + 1);
        }

        int last = -1;
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            if (last == nums[i]) continue;
            last = nums[i];
            visited[i] = true;
            boolean flag = dfs(nums, index + 1, curSum + nums[i], partition);
            if (flag) return true;
            visited[i] = false;
        }
        return false;
    }
}
