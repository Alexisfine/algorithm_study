package leetcode_questions.companies.citadel;

import java.util.HashMap;
import java.util.Map;

public class ProcessExecution {
    public static int deleteAndEarn(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        return 0;


    }
}
