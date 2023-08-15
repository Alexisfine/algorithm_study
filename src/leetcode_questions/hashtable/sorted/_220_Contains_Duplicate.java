package leetcode_questions.hashtable.sorted;

import java.util.TreeMap;

public class _220_Contains_Duplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int j = 0; j < nums.length; j++) {
            if (j > indexDiff) {
                int frequency = map.get((long) nums[j - indexDiff - 1]);
                if (frequency == 1) {
                    map.remove((long) nums[j - indexDiff - 1]);
                } else {
                    map.put((long) nums[j - indexDiff - 1], frequency - 1);
                }
            }
            var pos = map.ceilingKey((long) nums[j] - valueDiff);
            if (pos != null && Math.abs(pos - nums[j]) <= valueDiff) {
                return true;
            }
            map.put((long) nums[j], map.getOrDefault((long) nums[j], 0) + 1);
        }
        return false;
    }

    /*
    abs(nums[i]-nums[j]) <= valueDiff
    nums[j]-valueDiff <= nums[i] <= nums[j]+valueDiff

    [j-indexDiff+1, j-1]


     */
}
